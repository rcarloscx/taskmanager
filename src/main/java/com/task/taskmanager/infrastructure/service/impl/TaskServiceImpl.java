package com.task.taskmanager.infrastructure.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.taskmanager.domain.entity.Task;
import com.task.taskmanager.infrastructure.repository.TaskRepository;
import com.task.taskmanager.infrastructure.service.spec.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	TaskRepository taskRepository;

	@Override
	public List<Task> getAllTask() {
		return taskRepository.findAll();
	}

	@Override
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}
	
	@Override
	public Task getTaskById(Long idTask) {
		Task task = taskRepository.findById(idTask.intValue()).orElse(null);
        return task;
	}

	@Override
	public Task updateTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public boolean deleteTask(Long idTask) {
		try {
			taskRepository.deleteById(idTask.intValue());
            return true;
        } catch (Exception e) {
            return false;
        }
	}

}
