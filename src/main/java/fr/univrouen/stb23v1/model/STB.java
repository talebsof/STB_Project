package fr.univrouen.stb23v1.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@Entity
@Table(name = "stb")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stb", propOrder = {
    "title",
    "version",
    "date",
    "description",
    "client",
    "team",
    "features"
})
public class STB implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    @XmlElement(required = true)
    private String title;

    @Column(name = "version", nullable = false)
    @XmlElement(required = true)
    private String version;

    @Column(name = "date", nullable = false)
    @XmlElement(required = true)
    private String date;

    @Column(name = "description", nullable = false)
    @XmlElement(required = true)
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @XmlElement(required = true)
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    @XmlElement(required = true)
    private Team team;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "features_id", referencedColumnName = "id")
    @XmlElement(required = true)
    private Features features;
    

	 
	 
	public STB(String title, String version, String date, String description, Client client, Team team, Features features) {
		super();
		this.title 		= title;
		this.version 	= version;
		this.date 		= date;
		this.description= description;
		this.client 	= client;
		this.team 		= team;
		this.features 	= features;
	}
	
	public STB() {
	}
	
	public Long getId() {
		return this.id;
	}
	


	
	public void setFeatures(Features features) {
		 this.features = features;
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Team getTeam() {
		return team;
	}



	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		 this.client = client;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}


	public Features getFeatures() {
		return features;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}
