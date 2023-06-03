


package fr.univrouen.stb23v1.controlleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.univrouen.stb23v1.Repository.PersonRepository;
import fr.univrouen.stb23v1.Repository.STBRepository;
import fr.univrouen.stb23v1.model.Client;
import fr.univrouen.stb23v1.model.Features;
import fr.univrouen.stb23v1.model.Person;
import fr.univrouen.stb23v1.model.STB;
import fr.univrouen.stb23v1.model.STBResume;
import fr.univrouen.stb23v1.model.Team;

@Controller
@RequestMapping("/stb23")
public class POSTController {

	@Autowired
	private STBRepository stbRepository;

	@PostMapping(value = "/insert", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public ResponseEntity<STBResume> insertSTB(@RequestBody STB stb) {
	    String title = stb.getTitle();
	    String version = stb.getVersion();
	    String date = stb.getDate();
	    String description = stb.getDescription();
	    Client client = stb.getClient();
	    Team team = stb.getTeam();
	    Features features = stb.getFeatures();

	    if (stbRepository.existsByTitleAndVersionAndDate(title, version, date)) {
	        STBResume errorResponse = new STBResume();
	        errorResponse.setStatus("ERROR");
	        errorResponse.setDetail("DUPLICATED");
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	    }

	    STB newSTB = new STB(title, version, date, description, client, team, features);
	    STB savedSTB = stbRepository.save(newSTB);

	    STBResume response = new STBResume();
	    response.setId(savedSTB.getId());
	    response.setStatus("INSERTED");

	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	


}


