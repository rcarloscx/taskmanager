package com.task.taskmanager.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.taskmanager.domain.entity.State;

public interface StateRepository extends JpaRepository<State, Long>{

}
