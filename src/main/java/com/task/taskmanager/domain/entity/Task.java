package com.task.taskmanager.domain.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TblTask")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTask;
	
	@Column(name = "title")
	@NotNull(message = "El campo title es requerido")
	@NotBlank(message = "El campo title no debe ir en blanco")
	@Size(min = 10, max = 20, message="El campo title debe tener mínimo {min} y máximo {max} caracteres")
	@JsonProperty("title")
	private String title;
	
	@Column(name = "description")
	@NotNull(message = "El description name es requerido")
	@NotBlank(message = "El campo description no debe ir en blanco")
	@Size(min = 10, max = 20, message="El campo description debe tener mínimo {min} y máximo {max} caracteres")
	@JsonProperty("description")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_task")
    private UserTask usertask;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_state")
    private State state;

	public Long getIdTask() {
		return idTask;
	}

	public void setIdTask(Long idTask) {
		this.idTask = idTask;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserTask getUsertask() {
		return usertask;
	}

	public void setUsertask(UserTask usertask) {
		this.usertask = usertask;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
}
