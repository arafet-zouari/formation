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






@Entity
public class Organisme implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="OrganismeId")
	private Long IdOrganisme;
	private String Libelle;
	@OneToMany(mappedBy="session",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Session_de_Formation> mk1 = new HashSet<Session_de_Formation>();
	@OneToMany(mappedBy="organismes",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Formateur> mk = new HashSet<Formateur>();
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
	
	
	
}
