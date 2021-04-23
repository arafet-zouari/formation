package com.formation.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.formation.entities.Role;

import javax.persistence.JoinColumn;

@Entity
public class User  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="userid")
	private Long id;
	private String username;
	private String email;
	private String password;
	private String fname;
	private String lname;
	private String imageuser;
	
	//@ManyToMany(mappedBy="users",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
		//@ManyToMany(mappedBy="users",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
		@JsonIgnore
		@JsonBackReference
		 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(name = "USER_ROLES", joinColumns = {
	            @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
	            @JoinColumn(name = "ROLE_ID") })
	    private Set<Role> roles;
	
	public Long getId() {
		return id;
	}
	
	public User() {
		super();
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
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}



	public String getImageuser() {
		return imageuser;
	}



	public void setImageuser(String imageuser) {
		this.imageuser = imageuser;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", fname=" + fname + ", lname=" + lname
				+ ", imageuser=" + imageuser + "]";
	}
	public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
	
	
	
	
	

}
