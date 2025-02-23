package com.task.taskmanager.infrastructure.service.spec;

import java.util.List;

import com.task.taskmanager.domain.entity.State;

public interface StateService {

	public List<State> getAllState();
	public State createState(State state);
	public State getStateById(Long idState);
	public State updateState(State state);
	public boolean deleteState(Long idState);
	
}
