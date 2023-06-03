package fr.univrouen.stb23v1.controlleurs;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.xml.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import fr.univrouen.stb23v1.Repository.STBRepository;
import fr.univrouen.stb23v1.model.Client;
import fr.univrouen.stb23v1.model.STB;
import fr.univrouen.stb23v1.model.STBResume;
import fr.univrouen.stb23v1.util.ErrorMessage;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;




@Controller
public class GETController {
	
	private Marshaller jaxbMarshaller;
	private JAXBContext jaxbContext;
	
	
	
	@Autowired
	private STBRepository clientRepository;
	@Autowired
	private STBRepository teamRepository;
	@Autowired
	private STBRepository featuresRepository;
	@Autowired
	private STBRepository stbRepository;
	

	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}
	

	@RequestMapping("/help")
	public String help(ModelMap model) {
		return "help";
	}
	


    
	@GetMapping(value = "/stb23/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public List<STBResume> getSTBResumeXML() {
	    List<STB> stbList = stbRepository.findAll();
	    
	    List<STBResume> stbResumeList = new ArrayList<>();
	    for (STB stb : stbList) {
	        STBResume stbResume = new STBResume();
	        stbResume.setId(stb.getId());
	        stbResume.setTitre(stb.getTitle());
	        stbResume.setDescription(stb.getDescription());
	        stbResume.setDate(stb.getDate());

	        Client stbClient = new Client();
	        stbClient.setEntity(stb.getClient().getEntity());
	        stbClient.setPerson(null);
	        stbClient.setId(null);

	        stbResume.setClient(stbClient);

	        stbResumeList.add(stbResume);
	    }

	    return stbResumeList;
	}

	
	@GetMapping("/stb23/resume")
    public String showResume(Model model) {
        List<STB> stbList = stbRepository.findAll();
        model.addAttribute("stbList", stbList);
        return "resume";
    }
	
	@GetMapping(path = "/stb23/xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Object> detailSTB(@PathVariable Long id) throws JAXBException {
	    Optional<STB> stbOptional = stbRepository.findById(id);

	    if (stbOptional.isPresent()) {
	        STB stb = stbOptional.get();
	        
	        return ResponseEntity.ok(stb);
	    } else {
	        ErrorMessage errorMessage = new ErrorMessage(id, "ERROR");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	    }
	}
	
	@GetMapping(path = "/stb23/html/{id}", produces = MediaType.TEXT_HTML_VALUE)
	public String getSTBHTML(@PathVariable Long id, Model model) {
	    Optional<STB> stbOptional = stbRepository.findById(id);

	    if (stbOptional.isPresent()) {
	        STB stb = stbOptional.get();
	        model.addAttribute("stb", stb);
	        model.addAttribute("client", stb.getClient());
	        model.addAttribute("features", stb.getFeatures());
	        model.addAttribute("feature", stb.getFeatures().getFeature());
	        model.addAttribute("team", stb.getTeam());
	        model.addAttribute("person", stb.getClient().getPerson());
	        model.addAttribute("member", stb.getTeam().getMember());
	        model.addAttribute("personMember", stb.getTeam().getMember());


	        return "stb-details"; 
	    } else {
	        model.addAttribute("id", id);
	        model.addAttribute("status", "ERROR");
	        return "error"; 
	    }
	}

}
