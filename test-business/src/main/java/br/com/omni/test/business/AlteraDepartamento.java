package br.com.omni.test.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.omni.test.dao.ApiFacade;
import br.com.omni.test.model.DepartamentoEntity;

@Service
public class AlteraDepartamento implements Command<DepartamentoEntity> {
	@Autowired
	private ApiFacade facade;

	@Override
	public DepartamentoEntity executar(Object... params) throws Exception {
		return facade.alterarDepartamento((DepartamentoEntity) params[0]);
	}

}
