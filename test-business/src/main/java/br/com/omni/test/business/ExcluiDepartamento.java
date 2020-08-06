package br.com.omni.test.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.omni.test.dao.ApiFacade;

@Service
public class ExcluiDepartamento implements Command<Void> {
	@Autowired
	private ApiFacade facade;

	@Override
	public Void executar(Object... params) throws Exception {
		facade.excluirDepartamento((int) params[0]);
		return null;
	}

}
