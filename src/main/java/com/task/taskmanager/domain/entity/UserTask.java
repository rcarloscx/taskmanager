package com.task.taskmanager.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TblUser")
public class UserTask {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUserTask;

	@Column(name = "name", nullable = false)
	/*@NotNull(message = "El campo name es requerido")
	@NotBlank(message = "El campo name no debe ir en blanco")
	@Size(min = 12, max = 20, message = "El campo name debe tener un minimo de {min} o un maximo {max} caracteres")*/
	@JsonProperty("name")
	private String name;

	@Column(name = "lastname", nullable = false)
	/*@NotNull(message = "El campo lastname es requerido")
	@NotBlank(message = "El campo lastname no debe ir en blanco")
	@Size(min = 12, max = 20, message = "El campo lastname debe tener un minimo de {min} o un maximo {max} caracteres")*/
	@JsonProperty("lastname")
	private String lastname;

	@NotBlank
	@Size(max = 20)
	private String username;

	@Column(name = "email", nullable = false)
	@NotNull(message = "El campo email es requerido")
	@NotBlank(message = "El campo email no debe ir en blanco")
	@Size(min = 15, max = 30, message = "El campo email debe tener un minimo de {min} o un maximo {max} caracteres")
	@JsonProperty("email")
	private String email;

	@Column(name = "password", nullable = false)
	@NotNull(message = "El campo password es requerido")
	@NotBlank(message = "El campo password no debe ir en blanco")
	//@Size(min = 8, max = 12, message = "El campo password debe tener un minimo de {min} o un maximo {max} caracteres")
	@JsonProperty("password")
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public UserTask() {
	}

	public UserTask(String name, String lastname, String username, String email, String password) {
		this.name = name;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Long getIdUserTask() {
		return idUserTask;
	}

	public void setIdUserTask(Long idUserTask) {
		this.idUserTask = idUserTask;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
