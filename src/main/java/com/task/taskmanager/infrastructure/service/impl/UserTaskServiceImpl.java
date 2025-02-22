package com.task.taskmanager.infrastructure.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.task.taskmanager.domain.entity.UserTask;
import com.task.taskmanager.infrastructure.service.spec.UserTaskService;

@Service
public class UserTaskServiceImpl implements UserTaskService{

	@Override
	public List<UserTask> getAllUser() {
		List<UserTask> list = new ArrayList<>();
		UserTask item = new UserTask();
		item.setName("usertest");
		list.add(item);
		return list;
	}

}
