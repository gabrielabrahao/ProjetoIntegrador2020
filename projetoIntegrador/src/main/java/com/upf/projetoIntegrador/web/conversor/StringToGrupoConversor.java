package com.upf.projetoIntegrador.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.upf.projetoIntegrador.domain.estoque.Grupo;
import com.upf.projetoIntegrador.service.GrupoService;

@Component
public class StringToGrupoConversor implements Converter<String, Grupo> {

	@Autowired
	GrupoService service;
	
	@Override
	public Grupo convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

	
	
}
