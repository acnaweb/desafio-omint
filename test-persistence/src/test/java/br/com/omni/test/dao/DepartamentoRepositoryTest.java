package br.com.omni.test.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.omni.test.model.DepartamentoEntity;
import br.com.omni.test.model.DiretoriaEnum;
import br.com.omni.test.model.EstadoEnum;

@SpringBootTest
class DepartamentoRepositoryTest {
	@Autowired
	private DepartamentoRepository repository;

	@Test
	void whenCounting() {
		assertTrue(repository.count() >= 0);
	}

	@Test
	void whenPersistNew() {
		DepartamentoEntity entity = new DepartamentoEntity();

		entity.setCidade("São Paulo");
		entity.setEstado(EstadoEnum.SP);
		entity.setLocal("Local 1");
		entity.setDiretoria(DiretoriaEnum.NEGOCIO);
		entity.setNome("Departamento 1");

		assertTrue(repository.save(entity).getCodigo() > 0);

	}

	@Test
	void whenFindById() {
		Optional<DepartamentoEntity> optionalEntity = repository.findById(1);
		assertTrue(optionalEntity.isPresent());
		System.out.println(optionalEntity.get());
	}

	@Test
	void whenUpdate() {
		final int codigo = 2;
		final String nome = "Departamento " + System.currentTimeMillis();

		Optional<DepartamentoEntity> optionalEntity = repository.findById(codigo);
		DepartamentoEntity entity = optionalEntity.get();
		entity.setNome(nome);
		entity.setEstado(EstadoEnum.RJ);
		entity.setDiretoria(DiretoriaEnum.RECUPERACAO);

		repository.save(entity);
		assertTrue(repository.findById(codigo).get().getNome().equals(nome));
	}

	@Test
	void whenFindByNomeOrderByCidade() {
		List<DepartamentoEntity> departamentos = repository.findByNomeOrderByCidade("Departamento 1");

		assertTrue(departamentos.size() > 0);
	}

	@Test
	void findByEstado() {
		List<DepartamentoEntity> departamentos = repository.findByEstado(EstadoEnum.SP);
		assertTrue(departamentos.size() > 1);
		System.out.println(departamentos);
	}

}
