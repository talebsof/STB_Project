package fr.univrouen.stb23v1.controlleurs;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import fr.univrouen.stb23v1.Repository.STBRepository;
import fr.univrouen.stb23v1.model.Client;
import fr.univrouen.stb23v1.model.Features;
import fr.univrouen.stb23v1.model.STB;
import fr.univrouen.stb23v1.model.Team;

@Controller
public class DELETEController {


	@Autowired
	private STBRepository stbRepository;
	
	@Autowired
	private STBRepository clientRepository;
	@Autowired
	private STBRepository teamRepository;
	@Autowired
	private STBRepository featuresRepository;
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
	    try {
	        Optional<STB> stbOptional = stbRepository.findById(id);

	        if (stbOptional.isPresent()) {
	            STB stb = stbOptional.get();
	            
	            Client client = stb.getClient();
	            Team team = stb.getTeam();
	            Features features = stb.getFeatures();
	            
	            if (client != null) {
	                client.setPerson(null);  
	                clientRepository.deleteById(client.getId());
	            }
	            
	            if (team != null) {
	                teamRepository.deleteById(team.getId());
	            }
	            
	            if (features != null) {
	                featuresRepository.deleteById(features.getId());
	            }
	            
	            stbRepository.deleteById(id);
	            
	            return new ResponseEntity<Void>(HttpStatus.OK);
	        } else {
	            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	    }
	}

}