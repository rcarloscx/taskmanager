package com.task.taskmanager.infrastructure.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.task.taskmanager.domain.entity.UserTask;
import com.task.taskmanager.infrastructure.repository.UserTaskRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserTaskRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserTask user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}

}
