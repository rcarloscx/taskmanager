package com.task.taskmanager.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.taskmanager.domain.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
