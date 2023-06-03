package fr.univrouen.stb23v1.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@Entity
@Table(name = "feature")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "feature", propOrder = {
    "description",
    "priority",
    "delivery",
    "comment"
})
public class Feature implements Serializable{
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    @XmlElement(required = true)
    private String description;

    @Column(name = "priority", nullable = false)
    @XmlElement(required = true)
    private int priority;

    @Column(name = "delivery")
    @XmlElement(required = true)
    private String delivery;

    @Column(name = "comment")
    @XmlElement(required = true)
    private String comment;

    @Column(name = "name", nullable = false)
    @XmlAttribute(name = "name", required = true)
    private String name;

    @Column(name = "section", nullable = false)
    @XmlAttribute(name = "section", required = true)
    private int section;

    @Column(name = "number", nullable = false)
    @XmlAttribute(name = "number", required = true)
    private int number;
	
	
	public Feature(String name, Integer section, Integer number, String description, Integer priority, String delivery,String comment) {
		super();
		this.name 		= name;
		this.section   = section;
		this.number 	= number;
		this.description 	= description;
		this.priority 	= priority;
		this.delivery 	= delivery;
		this.comment = comment;
	}
	
	public Feature() {
	}

}

