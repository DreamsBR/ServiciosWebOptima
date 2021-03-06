package com.inmobiliaria.services.security.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        }),
        @UniqueConstraint(columnNames = {
                "id_colaborador"
        })
})
public class User{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user")
    private Long id;

    @NotBlank
    @Size(min=3, max = 50)
    private String name;

    @NotBlank
    @Size(min=3, max = 50)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    @Column(name="id_colaborador")
    private Integer idColaborador;

    @NotBlank
    @Size(min=6, max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", 
    	joinColumns = @JoinColumn(name = "id_user"), 
    	inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles = new HashSet<>();

    public User() {}

    public User(String name, String username, String email, Integer idColaborador, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.idColaborador = idColaborador;
        this.password = password;
    }

    public void setIdColaborador(Integer idColaborador) {
		this.idColaborador = idColaborador;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

	public Integer getIdColaborador() {
		return idColaborador;
	}
}