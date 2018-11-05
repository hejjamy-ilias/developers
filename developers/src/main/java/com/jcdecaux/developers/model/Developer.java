package com.jcdecaux.developers.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Developer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	private String firstname;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "developer_language",
	joinColumns = {@JoinColumn(name = "developer_id")},inverseJoinColumns = {@JoinColumn(name = "language_id")})
	private Set<Lang> languages;
	
	private int age;
	private Gender gender;
	
	public Developer() {}
	
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	public Set<Lang> getLanguages() {
		return new HashSet<Lang>(languages);
	}
	public void setLanguages(final Set<Lang> language) {
		this.languages = new HashSet<Lang>(language);
	}

	public int getAge() {
		return age;
	}
	public void setAge(final int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}
	public void setGender(final Gender gender) {
		this.gender = gender;
	}
	
	public void addLanguage(final Lang l) {
		this.languages.add(l);
	}
		
}
