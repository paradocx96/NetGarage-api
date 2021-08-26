//Name : Malwatta H.G.
//ID : IT19240848

package com.spm.netgarage.dal.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


//Create table
@Document(collection = "users")
public class User {

	//user Id is set to auto generate
	@Id
	private String id;
	private String username;
	private String password;
	private String email;
	
	@DBRef
	private Set<Role> roles = new HashSet<>();

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User( String username,String password,String email) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
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
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
