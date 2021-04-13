package com.formation.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.formation.entities.Participantsession;
import com.formation.repository.Participant_sessionRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ParticipantSessionController {
	private static final Logger logger = LogManager.getLogger(ParticipantSessionController.class);
	
	Participant_sessionRepository Participantsessionv;
	
	//pour ajouter un participant session
		@PostMapping("/addparticipantSession")
		public Participantsession createParticipant(@Valid @RequestBody Participantsession Participantsession) {
		    return Participantsessionv.save(Participantsession);
		}
		
	//delete Participant_session by IdProfil
		@DeleteMapping("/Participant_session/{IdSession}")
		public ResponseEntity<?> deleteParticipant_session(@PathVariable(value = "IdSession") Long IdSession) {
			Participantsession Participant_session = Participantsessionv.findById(IdSession).orElseThrow(null);
			//-> new ResourceNotFoundException("Participant_session", "IdSession", IdSession));

		   //ProfilRepository.deleteById(IdProfil);
			Participantsessionv.delete(Participant_session);

		    return ResponseEntity.ok().build();
		}
		//update Profil
		/*@PutMapping("/IdSession/{id}")
		public Participantsession updateParticipantsession(@PathVariable(value = "IdSession") Long IdSession,
		                                        @Valid @RequestBody Participantsession ParticipantsessionDetails) {

			Participantsession Participantsession = Participantsessionv.findById(IdSession).orElseThrow(null);
		    
		   
			Participantsession.setIdSession(ParticipantsessionDetails.getIdSession());
			Participantsession.setIdParticipant(ParticipantsessionDetails.getIdParticipant());
		    
			Participantsession updatedParticipantsession= Participantsession.save(Participantsession);
		    return Participantsession;
		}*/
}
