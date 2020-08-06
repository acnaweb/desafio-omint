package br.com.omni.test.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.omni.test.dao.ApiFacade;
import br.com.omni.test.model.DepartamentoEntity;

@Service
public class AdicionaDepartamento implements Command<Integer> {
	@Autowired
	private ApiFacade facade;

	@Override
	public Integer executar(Object... params) throws Exception {
		return facade.adicionarDepartamento((DepartamentoEntity) params[0]);
	}

}
