package br.com.marketmining.spring_boot_api.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marketmining.spring_boot_api.model.DepartamentoEntity;
import br.com.marketmining.spring_boot_api.model.EstadoEnum;

@Service
public class ApiFacade {

	@Autowired
	private DepartamentoRepository departamentoRepository;

	public Integer adicionarDepartamento(DepartamentoEntity entity) throws Exception {
		entity = departamentoRepository.save(entity);
		return entity.getCodigo();
	}

	public DepartamentoEntity alterarDepartamento(DepartamentoEntity entity) throws Exception {
		return departamentoRepository.save(entity);
	}

	public void excluirDepartamento(int codigo) throws Exception {
		Optional<DepartamentoEntity> optionalEntity = departamentoRepository.findById(codigo);
		if (!optionalEntity.isPresent())
			throw new IllegalArgumentException("Departamento não cadastrado");

		departamentoRepository.delete(optionalEntity.get());
	}

	public Optional<DepartamentoEntity> pesquisarPorCodigo(int codigo) throws Exception {
		return departamentoRepository.findById(codigo);
	}

	public List<DepartamentoEntity> listarDepartamentos() throws Exception {
		return departamentoRepository.findByOrderByCodigo();
	}

	public List<DepartamentoEntity> listarDepartamentosPorNome(String nome) throws Exception {
		return departamentoRepository.findByNomeOrderByCidade(nome);
	}

	public List<DepartamentoEntity> listarDepartamentosPorEstado(EstadoEnum estado) throws Exception {
		return departamentoRepository.findByEstado(estado);
	}

}
