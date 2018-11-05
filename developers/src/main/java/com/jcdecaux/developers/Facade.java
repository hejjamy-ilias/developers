package com.jcdecaux.developers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jcdecaux.developers.converters.DeveloperConverter;
import com.jcdecaux.developers.converters.LanguageConverter;
import com.jcdecaux.developers.model.Developer;
import com.jcdecaux.developers.model.DeveloperDTO;
import com.jcdecaux.developers.model.LangDTO;
import com.jcdecaux.developers.model.RequestObject;
import com.jcdecaux.developers.service.DeveloperService;


@RestController
@RequestMapping("/api")
public class Facade {
	
	private static final Logger logger = LoggerFactory.getLogger(Facade.class);
	
	@Autowired
	private DeveloperService developerService;
	
	@Autowired
	private DeveloperConverter developerConv;
	
	@Autowired
	private LanguageConverter languageConv;
	
	@GetMapping("/developers")
	public List<DeveloperDTO> getDevelopers(){
		return developerConv.createFromEntities(developerService.getDevelopers());
	}
	
	@GetMapping("/languages")
	public List<LangDTO> getLanguages(){
		return languageConv.createFromEntities(developerService.getLanguages());
	}
	
	@GetMapping("/developersByLanguage/{id}")
	public List<DeveloperDTO> getDevelopersByLanguage(@RequestParam long id){
		logger.debug(id+"");
		return developerConv.createFromEntities(developerService.getDeveloperByLanguage(id));
	}
	
	@PostMapping("/createDeveloper")
	public DeveloperDTO createDeveloper(@RequestBody DeveloperDTO dto){
		return developerConv.createFrom(developerService.createDeveloper(developerConv.createFrom(dto)));
	}
	
	@PutMapping("/updateDeveloper")
	public DeveloperDTO updateDeveloper(@RequestBody DeveloperDTO dto){
		return developerConv.createFrom(developerService.updateDeveloper(developerConv.createFrom(dto)));
	}
	
	@PostMapping("/setLanguage")
	public Developer setLanguage(@RequestBody RequestObject obj){
		return developerService.setLanguage(obj.getIdDeveloper(),obj.getIdLanguage());
	}
	
	@PostMapping("/createLanguage")
	public LangDTO createLanguage(@RequestBody LangDTO l){
		return languageConv.createFrom(developerService.createLanguage(languageConv.createFrom(l)));
	}
	
}
