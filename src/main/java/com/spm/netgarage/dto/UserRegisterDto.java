//Name : Malwatta H.G.
//ID : IT19240848

package com.spm.netgarage.dto;

public class UserRegisterDto {
	
	private String id;
	private String username;
	private String password;
	private String email;
	
	
	public UserRegisterDto(String id, String username, String email) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.username = username;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
