package com.jcdecaux.developers.converters;

import java.util.List;
import java.util.stream.Collectors;
import com.jcdecaux.developers.model.Developer;
import com.jcdecaux.developers.model.DeveloperDTO;

public interface DeveloperConverter {
	
	Developer createFrom(DeveloperDTO dto);
	DeveloperDTO createFrom(Developer entity);
	
	default List<DeveloperDTO> createFromEntities(final List<Developer> entities) {
		return entities.stream()
				.map(this::createFrom)
				.collect(Collectors.toList());
	}
	

	default List<Developer> createFromDtos(final List<DeveloperDTO> dtos) {
		return dtos.stream()
				.map(this::createFrom)
				.collect(Collectors.toList());
	}
}
