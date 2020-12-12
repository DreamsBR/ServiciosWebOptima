package com.inmobiliaria.services.security.message.request;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ChangePasswordAdminForm {
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    
    @NotBlank
    private String userName;
    
    private Set<String> role;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}
	
}
