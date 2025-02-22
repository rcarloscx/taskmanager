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
@Table(name = "TblUser")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUser;

	@Column(name = "name", nullable = false)
	@NotNull(message = "El campo name es requerido")
	@NotBlank(message = "El campo name no debe ir en blanco")
	@Size(min = 12, max = 20, message = "El campo name debe tener un minimo de {min} o un maximo {max} caracteres")
	@JsonProperty("name")
	private String name;
	
	@Column(name = "lastname", nullable = false)
	@NotNull(message = "El campo lastname es requerido")
	@NotBlank(message = "El campo lastname no debe ir en blanco")
	@Size(min = 12, max = 20, message = "El campo lastname debe tener un minimo de {min} o un maximo {max} caracteres")
	@JsonProperty("lastname")
	private String lastname;
	
	@Column(name = "email", nullable = false)
	@NotNull(message = "El campo email es requerido")
	@NotBlank(message = "El campo email no debe ir en blanco")
	@Size(min = 15, max = 30, message = "El campo email debe tener un minimo de {min} o un maximo {max} caracteres")
	@JsonProperty("email")
	private String email;
	
	@Column(name = "password", nullable = false)
	@NotNull(message = "El campo password es requerido")
	@NotBlank(message = "El campo password no debe ir en blanco")
	@Size(min = 8, max = 12, message = "El campo password debe tener un minimo de {min} o un maximo {max} caracteres")
	@JsonProperty("password")
	private String password;
	
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
