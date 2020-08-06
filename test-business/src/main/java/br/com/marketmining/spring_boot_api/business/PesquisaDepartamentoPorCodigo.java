package br.com.marketmining.spring_boot_api.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marketmining.spring_boot_api.dao.ApiFacade;
import br.com.marketmining.spring_boot_api.model.DepartamentoEntity;

@Service
public class PesquisaDepartamentoPorCodigo implements Command<Optional<DepartamentoEntity>> {
	@Autowired
	private ApiFacade facade;

	@Override
	public Optional<DepartamentoEntity> executar(Object... params) throws Exception {
		return facade.pesquisarPorCodigo((int) params[0]);

	}

}
