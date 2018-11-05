package com.jcdecaux.developers.converters;

import org.springframework.stereotype.Component;

import com.jcdecaux.developers.model.Developer;
import com.jcdecaux.developers.model.DeveloperDTO;

@Component
public class DeveloperConverterImpl implements DeveloperConverter{

	@Override
	public Developer createFrom(DeveloperDTO dto) {
		Developer d = new Developer();
		d.setId(dto.getId());
		d.setName(dto.getName());
		d.setFirstname(dto.getFirstname());
		d.setAge(dto.getAge());
		d.setGender(dto.getGender());
		d.setLanguages(dto.getLanguages());
		return d;
	}

	@Override
	public DeveloperDTO createFrom(Developer entity) {
		DeveloperDTO dto = new DeveloperDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setFirstname(entity.getFirstname());
		dto.setAge(entity.getAge());
		dto.setGender(entity.getGender());
		dto.setLanguages(entity.getLanguages());
		return dto;
	}

}
