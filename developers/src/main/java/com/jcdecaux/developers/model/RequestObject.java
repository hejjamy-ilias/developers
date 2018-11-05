package com.jcdecaux.developers.model;

import java.io.Serializable;

public class RequestObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long idDeveloper;
	private Long idLanguage;
	
	public long getIdDeveloper() {
		return idDeveloper;
	}
	public void setIdDeveloper(long idDeveloper) {
		this.idDeveloper = idDeveloper;
	}
	public Long getIdLanguage() {
		return idLanguage;
	}
	public void setIdLanguage(Long idLanguage) {
		this.idLanguage = idLanguage;
	}
	
	
}