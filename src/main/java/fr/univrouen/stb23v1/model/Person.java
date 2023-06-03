package fr.univrouen.stb23v1.model;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;



@Entity
@Table(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "person")
@XmlType(propOrder = {
    "value"
})
public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    @XmlValue
    private String value;

    @Column(name = "gender")
    @XmlAttribute(name = "gender")
    private String gender;

    @Column(name = "lastname", nullable = false)
    @XmlAttribute(name = "lastname", required = true)
    private String lastname;


		
	public Person(String firstname, String gender, String lastname) {
		super();
		this.value 	= firstname;
		this.gender 	= gender;
		this.lastname   = lastname;
	}
	
	public Person() {
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getLastname() {
		return this.lastname;
	}
	
	

}

