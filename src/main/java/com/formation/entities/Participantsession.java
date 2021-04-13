package com.formation.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;




@Entity
public class Participantsession  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="IdSession")
	private Long IdSession;
	private int IdParticipant;
	public Participantsession(Long idSession, int idParticipant) {
		super();
		IdSession = idSession;
		IdParticipant = idParticipant;
	}
	public Participantsession() {
		
		// TODO Auto-generated constructor stub
	}
	public Long getIdSession() {
		return IdSession;
	}
	public void setIdSession(Long idSession) {
		IdSession = idSession;
	}
	public int getIdParticipant() {
		return IdParticipant;
	}
	public void setIdParticipant(int idParticipant) {
		IdParticipant = idParticipant;
	}
	public Participantsession save(Participantsession participantsession) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
