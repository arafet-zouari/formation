package com.formation.controller;


import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.entities.Domaine;
import com.formation.repository.DomaineRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Domaine")
public class DomaineController {
	//private static final Logger logger = LogManager.getLogger(DomaineController.class);
	
	DomaineRepository Domainev;
	
	//pour ajouter un organisme
		@PostMapping("/addDomaine")
		public Domaine createDomaine(@Valid @RequestBody Domaine Domaine) {
		    return Domainev.save(Domaine);
		}
		
	//delete Organisme by IdOrganisme
		@DeleteMapping("/Domaine/{IdDomaine}")
		
			public ResponseEntity<?> deleteDomaine(@PathVariable(value = "IdDomaine") Long IdDomaine) {
			Domaine Domaine= Domainev.findById(IdDomaine).orElseThrow(null);

		   //OrganismeRepository.deleteByOrganisme(IdOrganisme);
			Domainev.delete(Domaine);

		    return ResponseEntity.ok().build();
		}
		//update Organisme
		@PutMapping("/IdDomaine/{id}")
		public Domaine updateDomaine(@PathVariable(value = "IdDomaine") Long IdDomaine,
		                                        @Valid @RequestBody Domaine DomaineDetails) {

			Domaine Domaine = Domainev.findById(IdDomaine).orElseThrow(null);
		    
		   
		    Domaine.setIdDomaine(DomaineDetails.getIdDomaine());
		    Domaine.setLibelle(DomaineDetails.getLibelle());
		   
		    
		    Domaine updatedDomaine= Domainev.save(Domaine);
		    return updatedDomaine;
		}
	        
}
