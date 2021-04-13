package com.formation.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

@Entity
public class Session_de_Formation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="SessionId")
	private Long IdSession;
	private int IdFormateur;
	private int IdOrganisme;
	private int IdFormation;
	private String Lieu;
	private Date Date_Debut;
	private Date Date_Fin;
	private int nb_participant;
@ManyToOne
	
    private Formateur sess;
@ManyToOne
	
    private Organisme session;
	public Session_de_Formation(Long idSession, int idFormateur, int idOrganisme, int idFormation, String lieu,
			Date date_Debut, Date date_Fin, int nb_participant) {
		super();
		IdSession = idSession;
		IdFormateur = idFormateur;
		IdOrganisme = idOrganisme;
		IdFormation = idFormation;
		Lieu = lieu;
		Date_Debut = date_Debut;
		Date_Fin = date_Fin;
		this.nb_participant = nb_participant;
	}
	public Session_de_Formation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdSession() {
		return IdSession;
	}
	public void setIdSession(long idSession) {
		IdSession = idSession;
	}
	public int getIdFormateur() {
		return IdFormateur;
	}
	public void setIdFormateur(int idFormateur) {
		IdFormateur = idFormateur;
	}
	public int getIdOrganisme() {
		return IdOrganisme;
	}
	public void setIdOrganisme(int idOrganisme) {
		IdOrganisme = idOrganisme;
	}
	public int getIdFormation() {
		return IdFormation;
	}
	public void setIdFormation(int idFormation) {
		IdFormation = idFormation;
	}
	public String getLieu() {
		return Lieu;
	}
	public void setLieu(String lieu) {
		Lieu = lieu;
	}
	public Date getDate_Debut() {
		return Date_Debut;
	}
	public void setDate_Debut(Date date_Debut) {
		Date_Debut = date_Debut;
	}
	public Date getDate_Fin() {
		return Date_Fin;
	}
	public void setDate_Fin(Date date_Fin) {
		Date_Fin = date_Fin;
	}
	public int getNb_participant() {
		return nb_participant;
	}
	public void setNb_participant(int nb_participant) {
		this.nb_participant = nb_participant;
	}
	
	
	


	
}
