package fr.univrouen.stb23v1.model;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;

@Entity
@Table(name = "mail")
@XmlRootElement
public class Mail implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@XmlValue
	private String mail;
	
	@ManyToOne
	private Client client;
	
	public Mail(String mail, Client client) {
		super();
		this.mail = mail;
		this.client = client;
	}	
	
	
	public Mail() {
	}

	
}



