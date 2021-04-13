package com.formation.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;



@Entity
public class Participant implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="ParticipantId")
	private Long IdParticipant;
	private String Nom;
	private String Prenom;
	private String Profil;
	private int IdOrganisme;
	private int IdPays;
	private int IdProfil;
	private String Email;
	private int Tlf;
@ManyToOne
	
    private Profil p;
	public Participant(Long idParticipant, String nom, String prenom, String profil, int idOrganisme, int idPays,
			int idProfil, String email, int tlf) {
		super();
		IdParticipant = idParticipant;
		Nom = nom;
		Prenom = prenom;
		Profil = profil;
		IdOrganisme = idOrganisme;
		IdPays = idPays;
		IdProfil = idProfil;
		Email = email;
		Tlf = tlf;
	}
	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdParticipant() {
		return IdParticipant;
	}
	public void setIdParticipant(Long idParticipant) {
		IdParticipant = idParticipant;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getProfil() {
		return Profil;
	}
	public void setProfil(String profil) {
		Profil = profil;
	}
	public int getIdOrganisme() {
		return IdOrganisme;
	}
	public void setIdOrganisme(int idOrganisme) {
		IdOrganisme = idOrganisme;
	}
	public int getIdPays() {
		return IdPays;
	}
	public void setIdPays(int idPays) {
		IdPays = idPays;
	}
	public int getIdProfil() {
		return IdProfil;
	}
	public void setIdProfil(int idProfil) {
		IdProfil = idProfil;
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
	
	
	



	
	
}
