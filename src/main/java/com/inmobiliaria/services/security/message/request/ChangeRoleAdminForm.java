package com.inmobiliaria.services.security.message.request;

import java.util.Set;

import javax.validation.constraints.NotBlank;

public class ChangeRoleAdminForm {
    @NotBlank
    private String userName;
    
    private Set<String> role;

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
