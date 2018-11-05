package com.jcdecaux.developers.service;

import java.util.List;
import com.jcdecaux.developers.model.Developer;
import com.jcdecaux.developers.model.Lang;

public interface DeveloperService {
	public List<Developer> getDevelopers();
	public List<Lang> getLanguages();
	public Developer setLanguage(Long idDeveloper,Long idLanguage);
	public Developer createDeveloper(Developer d);
	public Developer updateDeveloper(Developer d);
	public List<Developer> getDeveloperByLanguage(Long id);
	public Lang createLanguage(Lang l);
}