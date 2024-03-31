package com.helloworld.soap.service;

import java.util.List;

import com.helloworld.soap.tasks.gen.TaskDetail;


public interface TaskService {
	
	List<TaskDetail> getAllTask();
	
	Long addTask(TaskDetail taskDetail);
	
	Long completedTask(Long id);
	
	void deleteTask(Long id);

}
