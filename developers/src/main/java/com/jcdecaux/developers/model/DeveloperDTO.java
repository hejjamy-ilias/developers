package com.jcdecaux.developers.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class DeveloperDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String firstname;	
	private int age;
	private Gender gender;
	private Set<Lang> languages;
	
	public DeveloperDTO() {}
	
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
	
	public Set<Lang> getLanguages() {
		return new HashSet<Lang>(languages);
	}
	public void setLanguages(final Set<Lang> language) {
		this.languages = new HashSet<Lang>(language);
	}
}
