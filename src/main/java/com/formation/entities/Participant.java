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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.formation.entities.TypeParticipant; 
import com.formation.entities.Pays; 

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
	private TypeParticipant typeP; 
	private String Email;
	private int Tlf;
	
	@JsonBackReference
	@ManyToOne
    private Pays pays;
	
	@JsonIgnore
	@JsonBackReference
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @JoinTable(name = "Particicpant_session", joinColumns = {
           @JoinColumn(name = "id_participant") }, inverseJoinColumns = {
           @JoinColumn(name = "id_session") })
   private Set<Session_de_Formation> sessions;
   @JsonBackReference
    @ManyToOne
    private Profil p;
	public Participant(Long idParticipant, String nom, String prenom, String profil, int idOrganisme,String email, int tlf,TypeParticipant type ) {
		super();
		IdParticipant = idParticipant;
		Nom = nom;
		Prenom = prenom;
		Profil = profil;
		Email = email;
		Tlf = tlf;
		typeP=type; 
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	public Set<Session_de_Formation> getSessions() {
		return sessions;
	}
	public void setSessions(Set<Session_de_Formation> sessions) {
		this.sessions = sessions;
	}
	public TypeParticipant getTypeP() {
		return typeP;
	}
	public void setTypeP(TypeParticipant typeP) {
		this.typeP = typeP;
	}
	public int getTlf() {
		return Tlf;
	}
	public void setTlf(int tlf) {
		Tlf = tlf;
	}
	
	
	



	
	
}
