package com.inmobiliaria.services.security.message.request;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SendEmailChangePassordForm {
    @NotBlank
    @Size(min = 3, max = 50)
    private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
