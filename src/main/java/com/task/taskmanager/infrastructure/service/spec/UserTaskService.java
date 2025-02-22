package com.task.taskmanager.infrastructure.service.spec;

import java.util.List;

import com.task.taskmanager.domain.entity.UserTask;

public interface UserTaskService {
	
	public List<UserTask> getAllUser();
	public UserTask createUser(UserTask user);
	public UserTask updateUser(UserTask user);
	public boolean deleteUser(Integer idUser);

}
