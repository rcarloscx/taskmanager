package com.task.taskmanager.domain.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TblState")
public class State {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idState;
	
	@Column(name = "state")
	@NotNull(message = "El campo state es requerido")
	@NotBlank(message = "El campo state no debe ir en blanco")
	@Size(min = 4, max = 20, message="El campo state debe tener mínimo {min} y máximo {max} caracteres")
	@JsonProperty("state")
	private String state;
	
	@Column(name = "description")
	@NotNull(message = "El campo description es requerido")
	@NotBlank(message = "El campo description no debe ir en blanco")
	@Size(min = 10, max = 20, message="El campo description debe tener mínimo {min} y máximo {max} caracteres")
	@JsonProperty("description")
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "state")
	@JsonIgnore
    private List<Task> task;

	public Long getIdState() {
		return idState;
	}

	public void setIdState(Long idState) {
		this.idState = idState;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}
	
}
