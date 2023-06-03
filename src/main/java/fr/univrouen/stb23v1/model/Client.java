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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;



@Entity
@Table(name = "client")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "client", propOrder = {
    "entity",
    "person",
    "mailOrTel"
})
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entity", nullable = false)
    @XmlElement(required = true)
    private String entity;

    @OneToOne(cascade = CascadeType.ALL)
    @XmlElement(required = true)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @ElementCollection
    @CollectionTable(name = "client_contact", joinColumns = @JoinColumn(name = "client_id"))
    @Column(name = "contact")
    @XmlElements({
        @XmlElement(name = "mail", type = String.class),
        @XmlElement(name = "tel", type = String.class)
    })
    private List<String> mailOrTel;
    
	public Client(String entity, Person person,List<String> mailOrTel) {
		super();
		this.entity = entity;
		this.person = person;
		this.mailOrTel = mailOrTel;

	}	
	
	
	public Client() {
	}

	@Override
	public String toString() {
		return ("client [Entity=" + entity + "<br/>" +
						",firsname=" + person + "<br/>" +
						",mail=" + mailOrTel + "<br/>");
	}


	public String getEntity() {
		return entity;
	}


	public void setEntity(String entity) {
		this.entity = entity;
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


	public List<String> getMailOrTel() {
		return mailOrTel;
	}


	public void setMailOrTel(List<String> mailOrTel) {
		this.mailOrTel = mailOrTel;
	}
	
}



