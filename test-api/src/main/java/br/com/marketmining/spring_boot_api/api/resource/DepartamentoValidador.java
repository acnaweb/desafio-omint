package br.com.marketmining.spring_boot_api.api.resource;

import java.util.function.Predicate;

import br.com.marketmining.spring_boot_api.model.DepartamentoEntity;

public class DepartamentoValidador implements Predicate<DepartamentoEntity> {

	@Override
	public boolean test(DepartamentoEntity entity) {
		return entity != null && entity.getNome() != null && !entity.getNome().isEmpty() && entity.getCidade() != null
				&& !entity.getCidade().isEmpty() && entity.getLocal() != null && !entity.getLocal().isEmpty()
				&& entity.getDiretoria() != null && entity.getEstado() != null;
	}

}
