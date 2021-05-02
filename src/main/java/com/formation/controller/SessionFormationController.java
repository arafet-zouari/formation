package com.formation.controller;

import java.util.Date;
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
import com.formation.entities.Formateur;
import com.formation.entities.Formation;
import com.formation.entities.Organisme;
import com.formation.entities.Participant;
import com.formation.entities.Profil;
import com.formation.entities.Session_de_Formation;
import com.formation.repository.FormateurRepository;
import com.formation.repository.OrganismeRepository;
import com.formation.repository.Session_de_FormationRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class SessionFormationController {
	private static final Logger logger = LogManager.getLogger(SessionFormationController.class);
	
	
	@Autowired
	Session_de_FormationRepository Session_de_Formationv;
	@Autowired
	FormateurRepository Formateurv;
	@Autowired
	OrganismeRepository organismeR;
	
	@RequestMapping(value="/SessionFormation", method = RequestMethod.GET)
	public List<Session_de_Formation> getAllSessionFormation() {
		List<Session_de_Formation> pro = Session_de_Formationv.findAll();

        return pro;
	    
	}
	
	@GetMapping("/SessionFormation/{id}")
	public 	Session_de_Formation getParticipantById(@PathVariable(value = "id") Long Id) {
	    return 	Session_de_Formationv.findById(Id).orElseThrow(null);
	          
	}
	
	//pour ajouter une formation
		@PostMapping("/addSession_de_Formation/{Organismeid}/{IdFormateur}")
		public Session_de_Formation createSessionFormation(@PathVariable(value = "Organismeid") Long Organismeid,
		@PathVariable(value = "IdFormateur") Long IdFormateur,
		@Valid @RequestBody Session_de_Formation session_de_Formation) {
			
			
			Session_de_Formation  sessF=new Session_de_Formation ();
			   Organisme organisme = organismeR.findById(Organismeid).orElseThrow(null);
			   Formateur formateur=Formateurv.findById(IdFormateur).orElseThrow(null);
			   sessF.setFormateur(formateur);
			   sessF.setOrg(organisme);
			   sessF.setLieu(session_de_Formation.getLieu());
			   sessF.setDate_Debut(session_de_Formation.getDate_Debut());
			   sessF.setDate_Debut(session_de_Formation.getDate_Fin());
			   sessF.setNb_participant(session_de_Formation.getNb_participant());
			
		    return Session_de_Formationv.save(sessF);
		}
		
	//delete Formation by IdFormation
		@DeleteMapping("/Session_de_Formation/{IdSession}/{Organismeid}/{IdFormateur}")
		public ResponseEntity<?> deleteSessionFormation(@PathVariable(value = "IdSession") Long IdSession,
				@PathVariable(value = "Organismeid") Long Organismeid,
				@PathVariable(value = "IdFormateur") Long IdFormateur) {
			Session_de_Formation session_de_Formation = Session_de_Formationv.findById(IdSession).orElseThrow(null);
					//-> new ResourceNotFoundException("Formation", "IdSession", IdSession));

		   //FormateurRepository.deleteById(IdFormation);
			Session_de_Formationv.delete(session_de_Formation);

		    return ResponseEntity.ok().build();
		}
		//update Formation
		@PutMapping("/Session_de_FormationId/{IdSessionFormation}/{Organismeid}/{IdFormateur}")
		public Session_de_Formation updateSession_de_Formation(@PathVariable(value = "IdSessionFormation") Long IdSession,
				@PathVariable(value = "Organismeid") Long Organismeid,
				@PathVariable(value = "IdFormateur") Long IdFormateur,
		                                        @Valid @RequestBody Session_de_Formation SessionFormationDetails) {

			Session_de_Formation session_de_Formation = Session_de_Formationv.findById(IdSession).orElseThrow(null);
		    
			 Organisme organisme = organismeR.findById(Organismeid).orElseThrow(null);
			   Formateur formateur=Formateurv.findById(IdFormateur).orElseThrow(null);
			   session_de_Formation .setFormateur(formateur);
			   session_de_Formation .setOrg(organisme);
			session_de_Formation.setLieu(SessionFormationDetails.getLieu());
			session_de_Formation.setDate_Debut(SessionFormationDetails.getDate_Debut());
			session_de_Formation.setDate_Fin(SessionFormationDetails.getDate_Fin());
			session_de_Formation.setNb_participant(SessionFormationDetails.getNb_participant());
			

			
		    return Session_de_Formationv.save(session_de_Formation);
		}
}
