package com.jcdecaux.developers.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Lang implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
		
	@Size(max = 250)
	private String description;
	
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
	
	public String getDescription() {
		return description;
	}
	public void setDescription(final String description) {
		this.description = description;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
		
	@Override
	public boolean equals(Object obj){
	    if (obj == null) return false;
	    if (obj == this) return true;
	    if (!(obj instanceof Lang))return false;
	    Lang l = (Lang)obj;
	    if(this.id==l.getId())
	    	return true;
	    return false;
	}
}
