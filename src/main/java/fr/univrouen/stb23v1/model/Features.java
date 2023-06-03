package fr.univrouen.stb23v1.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@Entity
@Table(name = "features")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "features", propOrder = {
    "feature"
})
public class Features implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "features_id")
    @XmlElement(required = true)
    private List<Feature> feature;
    
	public Features(List<Feature> feature) {
		super();
		this.feature 	= feature;		
		
	}
	
	public Features() {
	}
	
	@Override
	public String toString() {
		return ("features[feature=" + feature + "]"+ "<br/>");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Feature> getFeature() {
		return feature;
	}

	public void setFeature(List<Feature> feature) {
		this.feature = feature;
	}
}


	
	
	
	

	
