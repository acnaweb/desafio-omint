package br.com.marketmining.spring_boot_api.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marketmining.spring_boot_api.dao.ApiFacade;
import br.com.marketmining.spring_boot_api.model.DepartamentoEntity;

@Service
public class ListaDepartamento implements Command<List<DepartamentoEntity>> {
	@Autowired
	private ApiFacade facade;

	@Override
	public List<DepartamentoEntity> executar(Object... params) throws Exception {
		return facade.listarDepartamentos();
	}

}
