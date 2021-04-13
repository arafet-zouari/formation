package com.formation.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="RoleId")
	private Long IdRole;
	 @Column
	private static String Nom;
	public Role() {
		
		// TODO Auto-generated constructor stub
	}
	public Role(Long idRole, String nom) {
		super();
		IdRole = idRole;
		Nom = nom;
	}
	public Long getIdRole() {
		return IdRole;
	}
	public void setIdRole(Long idRole) {
		IdRole = idRole;
	}
	public static String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	
	
}
