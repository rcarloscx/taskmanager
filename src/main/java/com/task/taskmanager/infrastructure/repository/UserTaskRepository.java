package com.task.taskmanager.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.taskmanager.domain.entity.UserTask;

public interface UserTaskRepository extends JpaRepository<UserTask, Integer>{

}
