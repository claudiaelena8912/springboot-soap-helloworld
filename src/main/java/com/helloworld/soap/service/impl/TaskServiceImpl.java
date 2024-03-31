package com.helloworld.soap.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloworld.soap.model.Task;
import com.helloworld.soap.repository.TaskRepository;
import com.helloworld.soap.service.TaskService;
import com.helloworld.soap.tasks.gen.TaskDetail;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public List<TaskDetail> getAllTask() {
		List<TaskDetail> taskDetails = taskRepository.findAll().stream().map(this::convertToTaskDetail)
				.collect(Collectors.toList());

		return taskDetails;
	}

	private TaskDetail convertToTaskDetail(Task task) {
		TaskDetail taskDetail = new TaskDetail();
		taskDetail.setTitle(task.getTitle());
		taskDetail.setDescription(task.getDescription());
		taskDetail.setCompleted(task.getCompleted());
		return taskDetail;
	}

	private Task convertToTask(TaskDetail taskDetail) {
		Task task = new Task();
		task.setTitle(taskDetail.getTitle());
		task.setDescription(taskDetail.getDescription());
		task.setCompleted(false);
		return task;
	}

	@Override
	public Long addTask(TaskDetail taskDetail) {
		Task task = convertToTask(taskDetail);
		return taskRepository.saveAndFlush(task).getId();
	}

	@Override
	public Long completedTask(Long id) {
		Long result = 0L;
		Optional<Task> optional = taskRepository.findById(id);
		if (optional.isPresent()) {
			optional.get().setCompleted(true);
			taskRepository.save(optional.get());
			result = optional.get().getId();
		}
		return result;
	}

	@Override
	public void deleteTask(Long id) {
		Optional<Task> optional = taskRepository.findById(id);
		if (optional.isPresent()) {
			taskRepository.delete(optional.get());
		}

	}

}
