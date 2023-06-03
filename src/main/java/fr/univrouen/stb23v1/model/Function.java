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
@Table(name = "function")
@XmlRootElement
public class Function implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@XmlValue
	private String function;
	
	@ManyToOne
	private Member member;
	
	public Function(String func, Member member) {
		super();
		this.function = func;
		this.member = member;
	}	
	
	
	public Function() {
	}

	
}
