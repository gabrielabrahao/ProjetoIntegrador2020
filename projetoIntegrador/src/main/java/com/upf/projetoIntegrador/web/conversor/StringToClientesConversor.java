package com.upf.projetoIntegrador.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.upf.projetoIntegrador.domain.geral.ClientesFornecedores;
import com.upf.projetoIntegrador.service.ClientesFornecedoresService;

@Component
public class StringToClientesConversor implements Converter<String, ClientesFornecedores>{

	@Autowired
	ClientesFornecedoresService service;
	
	@Override
	public ClientesFornecedores convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
}
