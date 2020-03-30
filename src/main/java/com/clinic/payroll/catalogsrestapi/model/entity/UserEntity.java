package com.clinic.payroll.catalogsrestapi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "\"user\"")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@NotNull
	@Column(unique = true)
	private String login;
	
	@NotNull
	@Column
	private String password;
	
	@NotNull
	@Column
	private String name;

	@Column(unique = true)
	private String email;
	
	public UserEntity() {
		super();
	}
	
	public UserEntity(@NotNull String login, @NotNull String password, @NotNull String name, String email) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	public UserEntity(Long userId, @NotNull String login, @NotNull String password, @NotNull String name, String email) {
		super();
		this.userId = userId;
		this.login = login;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", login=" + login + ", password=" + password + ", name=" + name + ", email="
				+ email + "]";
	}

}
