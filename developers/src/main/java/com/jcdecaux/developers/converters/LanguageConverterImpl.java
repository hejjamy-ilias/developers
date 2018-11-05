package com.jcdecaux.developers.converters;

import org.springframework.stereotype.Component;

import com.jcdecaux.developers.model.Lang;
import com.jcdecaux.developers.model.LangDTO;

@Component
public class LanguageConverterImpl implements LanguageConverter{

	@Override
	public Lang createFrom(LangDTO dto) {
		Lang l = new Lang();
		l.setId(dto.getId());
		l.setName(dto.getName());
		l.setDescription(dto.getDescription());
		return l;
	}

	@Override
	public LangDTO createFrom(Lang entity) {
		LangDTO dto = new LangDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		return dto;
	}

}
