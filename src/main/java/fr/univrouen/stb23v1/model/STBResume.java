package fr.univrouen.stb23v1.model;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlAccessType;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "stb")
@XmlAccessorType(XmlAccessType.FIELD)
public class STBResume {
    @XmlAttribute(name = "id")
    private Long id;
    
    @XmlElement(name = "title")
    private String title;
    
    @XmlElement(name = "description")
    private String description;
    
    @XmlElement(name = "date")
    private String date;
    
    @XmlElement(name = "client")
    private Client client;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return title;
	}

	public void setTitre(String titre) {
		this.title = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public Client getClient() {
	    return client;
	}

	public void setClient(Client client) {
	    this.client = client;
	}




}

