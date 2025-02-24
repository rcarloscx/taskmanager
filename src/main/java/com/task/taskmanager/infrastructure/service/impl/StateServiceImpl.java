package com.task.taskmanager.infrastructure.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.taskmanager.domain.entity.State;
import com.task.taskmanager.infrastructure.repository.StateRepository;
import com.task.taskmanager.infrastructure.service.spec.StateService;

@Service
public class StateServiceImpl implements StateService{
	
	@Autowired
	StateRepository stateRepository;

	@Override
	public List<State> getAllState() {
		return stateRepository.findAll();
	}

	@Override
	public State createState(State state) {
		return stateRepository.save(state);
	}
	
	@Override
	public State getStateById(Long idState) {
		State state = stateRepository.findById(idState).orElse(null);
        return state;
	}

	@Override
	public State updateState(State state) {
		return stateRepository.save(state);
	}

	@Override
	public boolean deleteState(Long idState) {
		try {
			stateRepository.deleteById(idState);
            return true;
        } catch (Exception e) {
            return false;
        }
	}

}
