package com.jcdecaux.developers.converters;

import java.util.List;
import java.util.stream.Collectors;
import com.jcdecaux.developers.model.Lang;
import com.jcdecaux.developers.model.LangDTO;

public interface LanguageConverter {
	Lang createFrom(LangDTO dto);
	LangDTO createFrom(Lang entity);
	
	default List<LangDTO> createFromEntities(final List<Lang> entities) {
		return entities.stream()
				.map(this::createFrom)
				.collect(Collectors.toList());
	}

	default List<Lang> createFromDtos(final List<LangDTO> dtos) {
		return dtos.stream()
				.map(this::createFrom)
				.collect(Collectors.toList());
	}
}
