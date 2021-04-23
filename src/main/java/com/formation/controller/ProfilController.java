package com.formation.controller;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
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

import com.formation.entities.Participant;
import com.formation.entities.Profil;
import com.formation.repository.ProfilRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ProfilController {
	private static final Logger logger = LogManager.getLogger(ProfilController.class);
	
	ProfilRepository Profilv;
	
	@RequestMapping(value="/Profils", method = RequestMethod.GET)
	public List<Profil> getAllProfil() {
		List<Profil> pro = Profilv.findAll();

        return pro;
	    
	}
	
	
	
	//pour ajouter un profil
		@PostMapping("/addProfil")
		public Profil createProfil(@Valid @RequestBody Profil Profil) {
		    return Profilv.save(Profil);
		}
		
	//delete Profil by IdProfil
		@DeleteMapping("/Profil/{IdProfil}")
		public ResponseEntity<?> deleteProfil(@PathVariable(value = "IdProfil") Long IdProfil) {
		    Profil Profil = Profilv.findById(IdProfil).orElseThrow(null);
		    //-> new ResourceNotFoundException("Profil", "IdProfil", IdProfil));

		   //ProfilRepository.deleteById(IdProfil);
		    Profilv.delete(Profil);

		    return ResponseEntity.ok().build();
		}
		//update Profil
		@PutMapping("/ProfilId/{id}")
		public Profil updateProfil(@PathVariable(value = "IdProfil") Long IdProfil,
		                                        @Valid @RequestBody Profil ProfilDetails) {

		    Profil Profil = Profilv.findById(IdProfil).orElseThrow(null);
		    
		   
		    Profil.setIdProfil(ProfilDetails.getIdProfil());
		    Profil.setLibelle(ProfilDetails.getLibelle());
		    
		    Profil updatedProfil= Profilv.save(Profil);
		    return updatedProfil;
		}
}
