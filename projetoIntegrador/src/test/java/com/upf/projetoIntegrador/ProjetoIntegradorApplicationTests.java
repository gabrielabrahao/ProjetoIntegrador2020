package com.upf.projetoIntegrador;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.ClientsConfiguredCondition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Service;

import com.upf.projetoIntegrador.dao.CidadeDao;
import com.upf.projetoIntegrador.dao.GrupoDao;
import com.upf.projetoIntegrador.domain.estoque.Grupo;
import com.upf.projetoIntegrador.domain.geral.Cidades;
import com.upf.projetoIntegrador.domain.geral.ClientesFornecedores;
import com.upf.projetoIntegrador.service.CidadeService;
import com.upf.projetoIntegrador.service.ClientesFornecedoresService;
import com.upf.projetoIntegrador.service.GrupoService;

@SpringBootTest
@Service
class ProjetoIntegradorApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private GrupoService grupoService;
	@Autowired
	private CidadeService cidadeService;
	@Autowired
	private ClientesFornecedoresService clientes;
	

	/*
	 * @Test void TestaNovaCidade() { Cidades c = new Cidades(); c.setNome("Teste");
	 * c.setUf("RS"); cidadeService.salvar(c); }
	 */
	@Test
	void listaCidades() {
		List<Cidades> list =  cidadeService.buscarTodos();
		for (Cidades cidades : list) {
			System.out.println(cidades.toString());
		}
	}
	

	@Test
	void testaNovoGrupo() {

		  Grupo grupo = new Grupo(); //grupo.setId(null);
		  grupo.setDescricao("Testes Novo 4");
          grupoService.salvar(grupo);
	}
	
	@Test
	void listaGrupos() {
		List<Grupo> list =  grupoService.buscarTodos();
		/*
		 * for (Grupo grupo : list) { System.out.println(list); }
		 */
		System.out.println(list);

	}
	
	@Test
	void NovoCliente() {
		ClientesFornecedores c = new ClientesFornecedores();
		c.setCpfCnpj("85028754004");
		LocalDate data  ;
		//c.setDataNascimento(data);
	}
	

	

}
