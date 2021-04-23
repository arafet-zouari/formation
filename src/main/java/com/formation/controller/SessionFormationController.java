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

import com.formation.entities.Profil;
import com.formation.entities.Session_de_Formation;
import com.formation.repository.Session_de_FormationRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class SessionFormationController {
	private static final Logger logger = LogManager.getLogger(SessionFormationController.class);
	
	
	
	Session_de_FormationRepository Session_de_Formationv;
	
	@RequestMapping(value="/SessionFormation", method = RequestMethod.GET)
	public List<Session_de_Formation> getAllSessionFormation() {
		List<Session_de_Formation> pro = Session_de_Formationv.findAll();

        return pro;
	    
	}
	
	
	
	//pour ajouter une formation
		@PostMapping("/addSession_de_Formation")
		public Session_de_Formation createSession_de_Formation(@Valid @RequestBody Session_de_Formation Session_de_Formation) {
		    return Session_de_Formationv.save(Session_de_Formation);
		}
		
	//delete Formation by IdFormation
		@DeleteMapping("/Session_de_Formation/{IdFormation}")
		public ResponseEntity<?> deleteSessionFormation(@PathVariable(value = "IdSession") Long IdSession) {
			Session_de_Formation Session_de_Formation = Session_de_Formationv.findById(IdSession).orElseThrow(null);
					//-> new ResourceNotFoundException("Formation", "IdSession", IdSession));

		   //FormateurRepository.deleteById(IdFormation);
			Session_de_Formationv.delete(Session_de_Formation);

		    return ResponseEntity.ok().build();
		}
		//update Formation
		@PutMapping("/Session_de_FormationId/{IdSessionFormation}")
		public Session_de_Formation updateSession_de_Formation(@PathVariable(value = "IdSessionFormation") Long IdSession,
		                                        @Valid @RequestBody Session_de_Formation SessionFormationDetails) {

			Session_de_Formation Session_de_Formation = Session_de_Formationv.findById(IdSession).orElseThrow(null);
		    
		   
			Session_de_Formation.setIdSession(SessionFormationDetails.getIdSession());
			Session_de_Formation.setLieu(SessionFormationDetails.getLieu());
			Session_de_Formation.setDate_Debut(SessionFormationDetails.getDate_Debut());
			Session_de_Formation.setDate_Fin(SessionFormationDetails.getDate_Fin());
			Session_de_Formation.setNb_participant(SessionFormationDetails.getNb_participant());
			

			Session_de_Formation updatedSession_de_Formation = Session_de_Formationv.save(Session_de_Formation);
		    return Session_de_Formation;
		}
}
