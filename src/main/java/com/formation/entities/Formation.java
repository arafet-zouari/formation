package com.formation.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Formation  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="IdFormation")
	private Long IdFormation;
	private String Titre;
	//private TypeParticipant Type_Formation;
	private int annee;
	private int Nb_session;
	private int Duree;
	private int IdDomaine ;
	private float Budget;
@ManyToOne
	
    private Domaine d;
	
	public Formation(Long idFormation, String titre,  int annee, int nb_session, int duree,
			int idDomaine, float budget) {
		super();
		IdFormation = idFormation;
		Titre = titre;
		this.annee = annee;
		Nb_session = nb_session;
		Duree = duree;
		IdDomaine = idDomaine;
		Budget = budget;
	}
	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdFormation() {
		return IdFormation;
	}
	public void setIdFormation(Long idFormation) {
		IdFormation = idFormation;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public int getNb_session() {
		return Nb_session;
	}
	public void setNb_session(int nb_session) {
		Nb_session = nb_session;
	}
	public int getDuree() {
		return Duree;
	}
	public void setDuree(int duree) {
		Duree = duree;
	}
	public int getIdDomaine() {
		return IdDomaine;
	}
	public void setIdDomaine(int idDomaine) {
		IdDomaine = idDomaine;
	}
	public float getBudget() {
		return Budget;
	}
	public void setBudget(float budget) {
		Budget = budget;
	}
	
	
	

	
	
}
