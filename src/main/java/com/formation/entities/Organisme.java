package com.formation.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonBackReference;






@Entity
public class Organisme implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="OrganismeId")
	private Long IdOrganisme;
	private String Libelle;
	
	@JsonBackReference
	@OneToMany(mappedBy="org",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Session_de_Formation> session = new HashSet<Session_de_Formation>();
	@JsonBackReference
	@OneToMany(mappedBy="organismes",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Formateur> formateur = new HashSet<Formateur>();
	public Organisme(Long idOrganisme, String libelle) {
		super();
		IdOrganisme = idOrganisme;
		Libelle = libelle;
	}
	public Organisme() {
		
		// TODO Auto-generated constructor stub
	}
	public Long getIdOrganisme() {
		return IdOrganisme;
	}
	public void setIdOrganisme(Long idOrganisme) {
		IdOrganisme = idOrganisme;
	}
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
	public Set<Session_de_Formation> getSession() {
		return session;
	}
	public void setSession(Set<Session_de_Formation> session) {
		this.session = session;
	}
	public Set<Formateur> getFormateur() {
		return formateur;
	}
	public void setFormateur(Set<Formateur> formateur) {
		this.formateur = formateur;
	}
	
	
	
}
