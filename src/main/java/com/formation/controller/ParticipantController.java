package com.formation.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formation.entities.Domaine;
import com.formation.entities.Formation;
import com.formation.entities.Organisme;
import com.formation.entities.Participant;
import com.formation.entities.Pays;
import com.formation.entities.Profil;
import com.formation.repository.ParticipantRepository;
import com.formation.repository.PaysRepository;
import com.formation.repository.ProfilRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ParticipantController {
	private static final Logger logger = LogManager.getLogger(ParticipantController.class);
	@Autowired
	ParticipantRepository Participantv;
	@Autowired
	ProfilRepository profilR;
	@Autowired
	PaysRepository paysR;
	
	
	@RequestMapping(value="/particicpants", method = RequestMethod.GET)
	public List<Participant> getAllParticipant() {
		List<Participant> pro = Participantv.findAll();

        return pro;
	    
	}
	
	@GetMapping("/Participant/{id}")
	public Participant getParticipantById(@PathVariable(value = "id") Long Id) {
	    return Participantv.findById(Id).orElseThrow(null);
	          
	}
	//pour ajouter un participant 
		@PostMapping("/addparticipant/{IdProfil}/{IdPays}")
		public Participant createParticipant(@PathVariable(value = "IdProfil") Long IdProfil,
				@PathVariable(value = "IdPays") Long IdPays,
				@Valid @RequestBody Participant participantDetails) {

		       Participant participant=new Participant();
			   Profil profil = profilR.findById(IdProfil).orElseThrow(null);
			   Pays pays = paysR.findById(IdPays).orElseThrow(null);
			      
				participant.setP(profil);
				participant.setPays(pays);
			    participant.setNom(participantDetails.getNom());
			    participant.setPrenom(participantDetails.getPrenom());
			    participant.setTypeP(participantDetails.getTypeP());
		    return Participantv.save(participant);
		}
		
	//delete Participant_session by IdProfil
		@DeleteMapping("/DeleteParticipant/{IdParticipant}")
		public ResponseEntity<?> deleteParticipant(@PathVariable(value = "IdParticipant") Long IdParticipant) {
			Participant participant = Participantv.findById(IdParticipant).orElseThrow(null);
					//-> new ResourceNotFoundException("Participant", "IdParticipant", IdParticipant));

		   //ProfilRepository.deleteById(IdProfil);
			Participantv.delete(participant);

		    return ResponseEntity.ok().build();
		}
		//update Profil
		@PutMapping("/UpdateParticipant/{IdParticipant}/{IdProfil}/{IdPays}")
		public Participant updateParticipant(@PathVariable(value = "IdParticipant")Long IdParticipant,
				@PathVariable(value = "IdProfil") Long IdProfil,
				@PathVariable(value = "IdPays") Long IdPays ,@Valid @RequestBody Participant participantDetails) {

			 Participant participant = Participantv.findById(IdParticipant).orElseThrow(null);
			   Profil profil = profilR.findById(IdProfil).orElseThrow(null);
			   Pays pays = paysR.findById(IdPays).orElseThrow(null);
			      
				participant.setP(profil);
				participant.setPays(pays);
			    participant.setNom(participantDetails.getNom());
			    participant.setPrenom(participantDetails.getPrenom());
			    participant.setTypeP(participantDetails.getTypeP());
			
			
		    return Participantv.save(participant);
		}
}
