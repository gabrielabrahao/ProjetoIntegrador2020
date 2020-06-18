package com.upf.projetoIntegrador.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.upf.projetoIntegrador.domain.estoque.Produtos;
import com.upf.projetoIntegrador.domain.estoque.ProdutosFornecedores;
import com.upf.projetoIntegrador.service.ProdutoService;
import com.upf.projetoIntegrador.service.ProdutosFornecedoresService;

@Component
public class StringToProdutosFornecedoresConversor implements Converter<String, ProdutosFornecedores> {
	
	@Override
	public ProdutosFornecedores convert(String text) {
		
		return new ProdutosFornecedores();
	}
	
	
}
