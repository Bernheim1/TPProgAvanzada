package com.javainuse.model;

public class UserDTO {
	private String username;
	private String password;
	private String rol;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRol() {
		return this.rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
}