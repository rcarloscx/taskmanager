package com.task.taskmanager.domain.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@Column(name = "id_user")
	private int idUser;
	
	@Column(name = "id_state")
	private int idState;

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

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdState() {
		return idState;
	}

	public void setIdState(int idState) {
		this.idState = idState;
	}
	
}
