package com.jcdecaux.developers.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jcdecaux.developers.exception.NotFoundException;
import com.jcdecaux.developers.model.Developer;
import com.jcdecaux.developers.model.Lang;
import com.jcdecaux.developers.repository.DeveloperRepo;
import com.jcdecaux.developers.repository.LanguageRepo;

@Service
public class DeveloperServiceImpl implements DeveloperService{

	@Autowired
	DeveloperRepo devRepo;
	
	@Autowired
	LanguageRepo languageRepo;
	
	@Override
	public List<Developer> getDevelopers() {
		return devRepo.findAll();
	}

	@Override
	public Developer setLanguage(final Long idDeveloper, final Long idLanguage) {
		Optional<Developer> developerOptional = devRepo.findById(idDeveloper);
		Optional<Lang> languageOptional = languageRepo.findById(idLanguage);
		if(!developerOptional.isPresent())
			throw new NotFoundException("Developer not found !");
		if(!languageOptional.isPresent())
			throw new NotFoundException("Language not found !");
		Developer d = developerOptional.get();
		d.addLanguage(languageOptional.get());
		return devRepo.save(d);
	}

	@Override
	public Developer createDeveloper(final Developer d) {
		d.setLanguages(getLang(d));
		return devRepo.save(d);
	}

	@Override
	public Developer updateDeveloper(final Developer d) {
		Optional<Developer> developerOptional = devRepo.findById(d.getId());
		if(!developerOptional.isPresent())
			throw new NotFoundException("Developer not found !");
		d.setLanguages(developerOptional.get().getLanguages());
		return  devRepo.save(d);
	}

	@Override
	public List<Developer> getDeveloperByLanguage(Long id) {
		Lang l = languageRepo.findById(id).get();
		return devRepo.findAll().stream()
        .filter(line -> line.getLanguages().stream().anyMatch(t -> t.equals(l)))
        .collect(Collectors.toList()); 
	}
	
	@Override
	public Lang createLanguage(final Lang l) {
		return languageRepo.save(l);
	}

	@Override
	public List<Lang> getLanguages() {
		return languageRepo.findAll();
	}
	
	private Set<Lang> getLang(Developer d){
		if(d.getLanguages()!=null) {
			Set<Lang> languages = new HashSet<Lang>();
			for(Lang l : d.getLanguages()) {
				Optional<Lang> langOptional = languageRepo.findById(l.getId());
				if(!langOptional.isPresent()) {
					Lang l1 = languageRepo.save(l);
					languages.add(l1);
				}
				else{
					languages.add(langOptional.get());
				}
			}
			return languages;
		}
		return null;
	}
}
