package br.com.marketmining.spring_boot_api.dao;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.marketmining.spring_boot_api.dao.ApiFacade;
import br.com.marketmining.spring_boot_api.model.DepartamentoEntity;
import br.com.marketmining.spring_boot_api.model.DiretoriaEnum;
import br.com.marketmining.spring_boot_api.model.EstadoEnum;

@SpringBootTest
class ApiFacadeTest {

	@Autowired
	private ApiFacade facade;

	@Test
	void whenAdicionarDepartamento() throws Exception {
		DepartamentoEntity entity = new DepartamentoEntity();

		entity.setCidade("Belo Horizonte");
		entity.setEstado(EstadoEnum.MG);
		entity.setLocal("Local Facade");
		entity.setDiretoria(DiretoriaEnum.EIS);
		entity.setNome("Departamento Facade");

		assertNotNull(facade.adicionarDepartamento(entity));

	}

	@Test
	void whenPesquisarPorCodigo() throws Exception {
		assertTrue(facade.pesquisarPorCodigo(1).isPresent());
	}

	@Test
	void whenAtualizarDepartamento() throws Exception {
		final int codigo = 2;
		final String nome = "Facade " + System.currentTimeMillis();

		Optional<DepartamentoEntity> optionalEntity = facade.pesquisarPorCodigo(codigo);

		DepartamentoEntity entity = optionalEntity.get();
		entity.setNome(nome);

		assertTrue(facade.alterarDepartamento(entity).getNome().equals(nome));
	}

	@Test
	void whenListarDepartamentos() throws Exception {
		List<DepartamentoEntity> departamentos = facade.listarDepartamentos();

		assertTrue(departamentos.size() > 0);
	}

	@Test
	void whenExcluirDepartamento() throws Exception {

		List<DepartamentoEntity> departamentos = facade.listarDepartamentos();
		DepartamentoEntity entity = departamentos.get(departamentos.size() - 1);

		System.out.println(entity);

		int codigo = entity.getCodigo();
		facade.excluirDepartamento(codigo);

		assertFalse(facade.pesquisarPorCodigo(codigo).isPresent());

	}

	@Test
	void whenListarDepartamentosPorNome() throws Exception {
		List<DepartamentoEntity> departamentos = facade.listarDepartamentosPorNome("Departamento 1");

		assertTrue(departamentos.size() > 0);
	}

	@Test
	void whenListarDepartamentosPorEstado() throws Exception {
		List<DepartamentoEntity> departamentos = facade.listarDepartamentosPorEstado(EstadoEnum.RJ);

		assertTrue(departamentos.size() > 0);
	}

}
