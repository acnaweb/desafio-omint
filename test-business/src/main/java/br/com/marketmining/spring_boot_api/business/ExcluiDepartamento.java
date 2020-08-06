package br.com.marketmining.spring_boot_api.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marketmining.spring_boot_api.dao.ApiFacade;

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
