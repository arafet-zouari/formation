package com.formation.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.formation.entities.Formation;
import com.formation.entities.TypeFormation;
import com.formation.entities.User;
import com.formation.repository.FormationRepository;
import com.formation.repository.DomaineRepository;

import com.formation.entities.Domaine;
import com.formation.entities.Formateur;





@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class FormationController {
	private static final Logger logger = LogManager.getLogger(FormationController.class);
	@Autowired
	FormationRepository Formationv;
	@Autowired
	DomaineRepository Domainev;
	
	
	@RequestMapping(value="/formation", method = RequestMethod.GET)
	public List<Formation> getAllformation() {
		List<Formation> pro = Formationv.findAll();

        return pro;
	    
	}
	
	@GetMapping("/Formation/{id}")
	public Formation getFormationById(@PathVariable(value = "id") Long Id) {
	    return Formationv.findById(Id).orElseThrow(null);
	          
	}
	//pour ajouter une formation
	    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
		@PostMapping("/addFormation/{Domaineid}")
		public Formation createFormation(@PathVariable(value = "Domaineid") Long Id, @Valid @RequestBody Formation formationDetails) {

		    
		       Formation me=new Formation();
			   Domaine domaine = Domainev.findById(Id).orElseThrow(null);
			   
			      
				  me.setDom(domaine);
			      me.setTitre(formationDetails.getTitre());
			      me.setAnnee(formationDetails.getAnnee());
			      me.setNb_session(formationDetails.getNb_session());
			      me.setDuree(formationDetails.getDuree());
			      me.setBudget(formationDetails.getBudget());
			      me.setTypeF(formationDetails.getTypeF());
			      
			      
			   return Formationv.save(me);
			
		

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
		@PutMapping("/FormationId/{IdFormation}/{IdDomaine}")
		public Formation updateFormation(@PathVariable(value = "IdFormation") Long IdFormation,
				@PathVariable(value = "IdDomaine") Long IdDomaine,
		                                        @Valid @RequestBody Formation formationDetails) {

		    Formation formation = Formationv.findById(IdFormation).orElseThrow(null);
		    Domaine domaine = Domainev.findById(IdDomaine).orElseThrow(null);
		 	formation.setTitre(formationDetails.getTitre());
		     formation.setAnnee(formationDetails.getAnnee());
		     formation.setNb_session(formationDetails.getNb_session());
		     formation.setDuree(formationDetails.getDuree());
		     formation.setBudget(formationDetails.getBudget());
		     formation.setTypeF(formationDetails.getTypeF());
		     formation.setDom(domaine);
		     return Formationv.save(formation);
		}
		
}
