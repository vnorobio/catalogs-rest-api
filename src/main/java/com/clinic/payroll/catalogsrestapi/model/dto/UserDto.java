package com.clinic.payroll.catalogsrestapi.model.dto;

public final class UserDto {
	
	private final String login;
	private final String password;
	private final String name;
	private final String email;
	
	private UserDto(String login, String password, String name, String email) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
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
		UserDto other = (UserDto) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserDto [login=" + login + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}
	
	

}
