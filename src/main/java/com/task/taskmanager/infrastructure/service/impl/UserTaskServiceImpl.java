package com.task.taskmanager.infrastructure.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.taskmanager.domain.entity.UserTask;
import com.task.taskmanager.infrastructure.repository.UserTaskRepository;
import com.task.taskmanager.infrastructure.service.spec.UserTaskService;

@Service
public class UserTaskServiceImpl implements UserTaskService{
	
	@Autowired
	UserTaskRepository userTaskRepository;

	@Override
	public List<UserTask> getAllUser() {
		return userTaskRepository.findAll();
	}

	@Override
	public UserTask createUser(UserTask user) {
		return userTaskRepository.save(user);
	}
	
	@Override
	public UserTask getUserById(Long idUser) {
		UserTask usuario = userTaskRepository.findById(idUser).orElse(null);
        return usuario;
	}

	@Override
	public UserTask updateUser(UserTask user) {
		return userTaskRepository.save(user);
	}

	@Override
	public boolean deleteUser(Long idUser) {
		try {
			userTaskRepository.deleteById(idUser);
            return true;
        } catch (Exception e) {
            return false;
        }
	}

}
