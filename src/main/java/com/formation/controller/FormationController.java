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

import com.formation.entities.Formation;
import com.formation.repository.FormationRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class FormationController {
	private static final Logger logger = LogManager.getLogger(FormationController.class);
	@Autowired
	FormationRepository Formationv;
	
	//pour ajouter une formation
		@PostMapping("/addFormation")
		public Formation createFormation(@Valid @RequestBody Formation Formation) {
		    return Formationv.save(Formation);
		}
		
	//delete Formation by IdFormation
		@DeleteMapping("/Formation/{IdFormation}")
		public ResponseEntity<?> deleteFormation(@PathVariable(value = "IdFormation") Long IdFormation) {
		    Formation Formation = Formationv.findById(IdFormation).orElseThrow(null);
		    		//-> new ResourceNotFoundException("Formation", "IdFormation", IdFormation));

		   //FormateurRepository.deleteById(IdFormation);
		    Formationv.delete(Formation);

		    return ResponseEntity.ok().build();
		}
		//update Formation
		@PutMapping("/FormationId/{IdFormation}")
		public Formation updateFormation(@PathVariable(value = "IdFormation") Long IdFormation,
		                                        @Valid @RequestBody Formation FormationDetails) {

		    Formation Formation = Formationv.findById(IdFormation).orElseThrow(null);
		    
		   
		    Formation.setIdFormation(FormationDetails.getIdFormation());
		    Formation.setTitre(FormationDetails.getTitre());
		    Formation.setType_Formation(FormationDetails.getType_Formation());
		   Formation.setAnnee(FormationDetails.getAnnee());
		   Formation.setNb_session(FormationDetails.getNb_session());
		   Formation.setDuree(FormationDetails.getDuree());
		   Formation.setIdDomaine(FormationDetails.getIdDomaine());
		   Formation.setBudget(FormationDetails.getBudget());

		    Formation updatedFormation = Formationv.save(Formation);
		    return updatedFormation;
		}
		
}
