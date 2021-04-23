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

import com.formation.entities.Formation;
import com.formation.entities.Organisme;
import com.formation.repository.OrganismeRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class OrganismeController {
	//private static final Logger logger = LogManager.getLogger(OrganismeController.class);
	@Autowired
	OrganismeRepository Organismev;
	
	@RequestMapping(value="/organismes", method = RequestMethod.GET)
	public List<Organisme> getAllOrganisme() {
		List<Organisme> pro = Organismev.findAll();

        return pro;
	    
	}
	
	
	//pour ajouter un organisme
		@PostMapping("/addOrganisme")
		public Organisme createOrganisme(@Valid @RequestBody Organisme Organisme) {
		    return Organismev.save(Organisme);
		}
		
	//delete Organisme by IdOrganisme
		@DeleteMapping("/Organisme/{IdOrganisme}")
		public ResponseEntity<?> deleteOrganisme(@PathVariable(value = "IdOrganisme") Long IdOrganisme) {
		    Organisme Organisme = Organismev.findById(IdOrganisme).orElseThrow(null) ;
		    		//-> new ResourceNotFoundException("Organisme", "IdOrganisme", IdOrganisme));

		   //OrganismeRepository.deleteByOrganisme(IdOrganisme);
		    Organismev.delete(Organisme);

		    return ResponseEntity.ok().build();
		}
		//update Organisme
		@PutMapping("/IdOrganisme/{id}")
		public Organisme updateOrganisme(@PathVariable(value = "IdOrganisme") Long IdOrganisme,
		                                        @Valid @RequestBody Organisme OrganismeDetails) {

		    Organisme Organisme = Organismev.findById(IdOrganisme).orElseThrow(null);
		    
		   
		    Organisme.setIdOrganisme(OrganismeDetails.getIdOrganisme());
		    Organisme.setLibelle(OrganismeDetails.getLibelle());
		    
		    Organisme updatedOrganisme= Organismev.save(Organisme);
		    return updatedOrganisme;
		}
}
