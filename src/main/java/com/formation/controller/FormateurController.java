package com.formation.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.formation.entities.Domaine;
import com.formation.entities.Formateur;
import com.formation.repository.FormateurRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class FormateurController {
	private static final Logger logger = LogManager.getLogger(FormateurController.class);
	@Autowired
	FormateurRepository Formateurv;
	
	
	@RequestMapping(value="/formateur", method = RequestMethod.GET)
	public List<Formateur> getAllFormateurs() {
		List<Formateur> pro = Formateurv.findAll();

		
        return pro;
	    
	}
	
	
	//pour ajouter un formateur
		@PostMapping("/addFormateur")
		public Formateur createFormateur(@Valid @RequestBody Formateur Formateur) {
		    return Formateurv.save(Formateur);
		}
		
	//delete user by IdFormateur
		@DeleteMapping("/Formateur/{IdFormateur}")
			public ResponseEntity<?> deleteFormateur(@PathVariable(value = "IdFormateur") Long IdFormateur) {
			    Formateur Formateur = Formateurv.findById(IdFormateur).orElseThrow(null);
		    		//-> new ResourceNotFoundException("Formateur", "IdFormateur", IdFormateur));

		   //FormateurRepository.deleteById(IdFormateur);
		    Formateurv.delete(Formateur);

		    return ResponseEntity.ok().build();
		}
		//update Formateur
		@PutMapping("/FormateurId/{id}")
		public Formateur updateFormateur(@PathVariable(value = "IdFormateur") Long IdFormateur,
		                                        @Valid @RequestBody Formateur FormateurDetails) {

		    
		    
		    Formateur Formateur = Formateurv.findById(IdFormateur).orElseThrow(null);
		    Formateur.setIdFormateur(FormateurDetails.getIdFormateur());
		    Formateur.setNom(FormateurDetails.getNom());
		    Formateur.setPrenom(FormateurDetails.getPrenom());
		   Formateur.setEmail(FormateurDetails.getEmail());
		   Formateur.setTlf(FormateurDetails.getTlf());
		   Formateur.setType(FormateurDetails.getType());

		    Formateur updatedFormateur = Formateurv.save(Formateur);
		    return updatedFormateur;
		}
		
}
