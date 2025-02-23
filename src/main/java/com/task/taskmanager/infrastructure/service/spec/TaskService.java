package com.task.taskmanager.infrastructure.service.spec;

import java.util.List;

import com.task.taskmanager.domain.entity.Task;

public interface TaskService {
	
	public List<Task> getAllTask();
	public Task createTask(Task task);
	public Task getTaskById(Long idTask);
	public Task updateTask(Task task);
	public boolean deleteTask(Long idtasj);

}
