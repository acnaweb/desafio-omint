package br.com.marketmining.spring_boot_api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marketmining.spring_boot_api.model.DepartamentoEntity;
import br.com.marketmining.spring_boot_api.model.EstadoEnum;

interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Integer> {

	public List<DepartamentoEntity> findByNomeOrderByCidade(String nome);

	public List<DepartamentoEntity> findByEstado(EstadoEnum estado);

	public List<DepartamentoEntity> findByOrderByCodigo();

}
