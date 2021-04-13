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

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.JoinColumn;

@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="usercode")
	private Long code;
	private String Login;
	private String pwd;
	private int IdRole;
	
	
	
@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinTable(name = "USER_ROLES", joinColumns = {
           @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
           @JoinColumn(name = "ROLE_ID") })
private Set<Role> roles;
@JsonIgnore
	
	public User(Long code, String login, String pwd, int idRole) {
		super();
		this.code = code;
		Login = login;
		this.pwd = pwd;
		IdRole = idRole;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getIdRole() {
		return IdRole;
	}
	public void setIdRole(int idRole) {
		IdRole = idRole;
	}
	public Iterable<SimpleGrantedAuthority> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}
		
	
}

