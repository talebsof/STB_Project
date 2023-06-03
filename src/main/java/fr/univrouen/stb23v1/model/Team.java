package fr.univrouen.stb23v1.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@Entity
@Table(name = "team")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "team", propOrder = {
    "member"
})
public class Team implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    @XmlElement(required = true)
    private List<Member> member;

	public Team(List<Member> member) {
		super();
		this.member = member;
	}
	
	public Team() {
	}
	
	@Override
	public String toString() {
		return ("team [member=" + member + "]" + "<br/>");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Member> getMember() {
		return member;
	}

	public void setMember(List<Member> member) {
		this.member = member;
	}
	
}

