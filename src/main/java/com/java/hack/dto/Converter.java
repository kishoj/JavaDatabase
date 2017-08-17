package com.java.hack.dto;

import java.io.Serializable;

public interface Converter<DTO, ENTITY> extends Serializable {
	DTO convertToDTO(ENTITY entity);
	ENTITY convertTOEntity(DTO dto);
}
