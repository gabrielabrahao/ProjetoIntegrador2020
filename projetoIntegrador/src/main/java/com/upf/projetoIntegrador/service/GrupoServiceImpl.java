package com.upf.projetoIntegrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upf.projetoIntegrador.dao.GrupoDao;
import com.upf.projetoIntegrador.domain.estoque.Grupo;

@Service
@Transactional(readOnly = false)//Essa informação é implicita, informado apenas para conhecimento
public class GrupoServiceImpl implements GrupoService {

   @Autowired
   private GrupoDao dao;
	
	@Override
	public void salvar(Grupo grupo) {
		dao.save(grupo);
	}

	@Override
	public void editar(Grupo grupo) {
		dao.update(grupo);
		
	}

	@Override
	public void excluir(long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Grupo buscarPorId(Long id) {
		return dao.findByID(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Grupo> buscarTodos() {
		return dao.findAll();
	}

}
