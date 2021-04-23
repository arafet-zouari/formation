package com.formation.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formation.entities.Organisme;
import com.formation.entities.Participant;
import com.formation.repository.ParticipantRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ParticipantController {
	private static final Logger logger = LogManager.getLogger(ParticipantController.class);
	@Autowired
	ParticipantRepository Participantv;
	
	
	@RequestMapping(value="/particicpants", method = RequestMethod.GET)
	public List<Participant> getAllParticipant() {
		List<Participant> pro = Participantv.findAll();

        return pro;
	    
	}
	
	
	//pour ajouter un participant 
		@PostMapping("/addparticipant")
		public Participant createParticipant(@Valid @RequestBody Participant Participant) {
		    return Participantv.save(Participant);
		}
		
	//delete Participant_session by IdProfil
		@DeleteMapping("/Participant/{IdParticipant}")
		public ResponseEntity<?> deleteParticipant(@PathVariable(value = "IdParticipant") Long IdParticipant) {
			Participant Participant = Participantv.findById(IdParticipant).orElseThrow(null);
					//-> new ResourceNotFoundException("Participant", "IdParticipant", IdParticipant));

		   //ProfilRepository.deleteById(IdProfil);
			Participantv.delete(Participant);

		    return ResponseEntity.ok().build();
		}
		//update Profil
		@PutMapping("/IdParticipant/{id}")
		public Participant updateParticipant(@PathVariable(value = "IdParticipant") Long IdParticipant,
		                                        @Valid @RequestBody Participant ParticipantDetails) {

			Participant Participant = Participantv.findById(IdParticipant).orElseThrow(null);
		    
		   
			Participant.setIdParticipant(ParticipantDetails.getIdParticipant());
			Participant.setIdParticipant(ParticipantDetails.getIdParticipant());
		    
			Participant updatedParticipant= Participantv.save(Participant);
		    return Participant;
		}
}
