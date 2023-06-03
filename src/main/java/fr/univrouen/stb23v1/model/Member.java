package fr.univrouen.stb23v1.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

@Entity
@Table(name = "member")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "member", propOrder = {
    "person",
    "mail",
    "function"
})
public class Member implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @XmlElement(required = true)
    private Person person;

    @Column(name = "mail", nullable = false)
    @XmlElement(required = true)
    private String mail;

    @ElementCollection
    @CollectionTable(name = "member_function", joinColumns = @JoinColumn(name = "member_id"))
    @Column(name = "function")
    @XmlElement(required = true)
    private List<String> function;

	
	public Member(Person person, String mail, List<String>function) {
		super();
		this.person 	= person;
		this.mail = mail;
		this.function 	= function;
	}
	
	public Member() {
	}

	@Override
	public String toString() {
		return ("member [person=" +"<br/>" + person + ",function=" + function  +"]");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<String> getFunction() {
		return function;
	}

	public void setFunction(List<String> function) {
		this.function = function;
	}
	
}

