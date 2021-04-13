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

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;








@Entity
public class Formateur implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="FormateurId")
	private Long IdFormateur;
	private String nom;
	private String prenom;
	private String Email;
	private int Tlf;
	private int IdOrganisme;
	private String Type;
	@OneToMany(mappedBy="sess",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Session_de_Formation> mk = new HashSet<Session_de_Formation>();
	
@ManyToOne
	
    private Organisme organismes;

	public Formateur(Long idFormateur, String nom, String prenom, String email, int tlf, int idOrganisme, String type) {
		super();
		IdFormateur = idFormateur;
		this.nom = nom;
		this.prenom = prenom;
		Email = email;
		Tlf = tlf;
		IdOrganisme = idOrganisme;
		Type = type;
	}
	public Formateur() {
		
		// TODO Auto-generated constructor stub
	}
	public Long getIdFormateur() {
		return IdFormateur;
	}
	public void setIdFormateur(Long idFormateur) {
		IdFormateur = idFormateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getTlf() {
		return Tlf;
	}
	public void setTlf(int tlf) {
		Tlf = tlf;
	}
	public int getIdOrganisme() {
		return IdOrganisme;
	}
	public void setIdOrganisme(int idOrganisme) {
		IdOrganisme = idOrganisme;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	
	
}
