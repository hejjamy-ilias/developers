package com.jcdecaux.developers.model;

import java.io.Serializable;

public class LangDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
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
	public boolean equals(Object obj){
	    if (obj == null) return false;
	    if (obj == this) return true;
	    if (!(obj instanceof Lang))return false;
	    Lang l = (Lang)obj;
	    if(this.id==l.getId() && this.name.equals(l.getName()))
	    	return true;
	    return false;
	}
}
