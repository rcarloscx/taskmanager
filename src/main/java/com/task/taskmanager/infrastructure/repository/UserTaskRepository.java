package com.task.taskmanager.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.taskmanager.domain.entity.UserTask;

public interface UserTaskRepository extends JpaRepository<UserTask, Long>{
	
	  Optional<UserTask> findByUsername(String username);

	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);

}
