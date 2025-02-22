package com.task.taskmanager.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.taskmanager.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
