package com.helloworld.soap.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.helloworld.soap.service.TaskService;
import com.helloworld.soap.tasks.gen.AddTaskRequest;
import com.helloworld.soap.tasks.gen.AddTaskResponse;
import com.helloworld.soap.tasks.gen.CompletedTaskRequest;
import com.helloworld.soap.tasks.gen.CompletedTaskResponse;
import com.helloworld.soap.tasks.gen.DeleteTaskRequest;
import com.helloworld.soap.tasks.gen.DeleteTaskResponse;
import com.helloworld.soap.tasks.gen.GetTaskRequest;
import com.helloworld.soap.tasks.gen.GetTaskResponse;
import com.helloworld.soap.tasks.gen.TaskDetail;
import com.helloworld.soap.tasks.gen.TaskDetailsList;

@Endpoint
public class TaskEndpoint {

	private static final String NAMESPACE_URI = "http://soap.helloworld.com/tasks/gen";

	@Autowired
	private TaskService taskService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetTaskRequest")

	@ResponsePayload
	public GetTaskResponse getTasks(@RequestPayload GetTaskRequest request) {
		List<TaskDetail> taskDetails = taskService.getAllTask();

		TaskDetailsList taskDetailsList = new TaskDetailsList();
		taskDetailsList.getTaskDetail().addAll(taskDetails);

		GetTaskResponse response = new GetTaskResponse();
		response.setTaskDetails(taskDetailsList);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddTaskRequest")

	@ResponsePayload
	public AddTaskResponse addTask(@RequestPayload AddTaskRequest request) {
		Long id = taskService.addTask(request.getTaskDetail());

		AddTaskResponse response = new AddTaskResponse();
		response.setId(id);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "CompletedTaskRequest")

	@ResponsePayload
	public CompletedTaskResponse completedTask(@RequestPayload CompletedTaskRequest request) {
		Long id = taskService.completedTask(request.getId());

		CompletedTaskResponse response = new CompletedTaskResponse();
		response.setId(id);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteTaskRequest")

	@ResponsePayload
	public DeleteTaskResponse completedTask(@RequestPayload DeleteTaskRequest request) {
		taskService.deleteTask(request.getId());

		DeleteTaskResponse response = new DeleteTaskResponse();
		return response;
	}

}
