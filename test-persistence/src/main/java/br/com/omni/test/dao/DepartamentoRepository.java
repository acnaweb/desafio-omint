package br.com.omni.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.omni.test.model.DepartamentoEntity;
import br.com.omni.test.model.EstadoEnum;

interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Integer> {

	public List<DepartamentoEntity> findByNomeOrderByCidade(String nome);

	public List<DepartamentoEntity> findByEstado(EstadoEnum estado);

	public List<DepartamentoEntity> findByOrderByCodigo();

}
