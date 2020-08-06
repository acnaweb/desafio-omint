package br.com.marketmining.spring_boot_api.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.marketmining.spring_boot_api.api.spring.CustomResponse;
import br.com.marketmining.spring_boot_api.api.spring.CustomResponseBuilder;
import br.com.marketmining.spring_boot_api.business.AdicionaDepartamento;
import br.com.marketmining.spring_boot_api.business.AlteraDepartamento;
import br.com.marketmining.spring_boot_api.business.Command;
import br.com.marketmining.spring_boot_api.business.ExcluiDepartamento;
import br.com.marketmining.spring_boot_api.business.ListaDepartamento;
import br.com.marketmining.spring_boot_api.business.PesquisaDepartamentoPorCodigo;
import br.com.marketmining.spring_boot_api.model.DepartamentoEntity;
import io.swagger.annotations.Api;

@RestController
@Api(description = "Gerenciamento de Departamentos", produces = "application/json")
@RequestMapping(path = "/departments", produces = "application/json")
public class DepartamentoResource {
	@Autowired
	private ApplicationContext context;

	private static DepartamentoValidador departamentoValidador = new DepartamentoValidador();

	@GetMapping
	public ResponseEntity<CustomResponse> pesquisarDepartamentoPorCodigo(@RequestParam(name = "code") String codigo) {

		try {

			Command<Optional<DepartamentoEntity>> command = context.getBean(PesquisaDepartamentoPorCodigo.class);
			Optional<DepartamentoEntity> result = command.executar(Integer.parseInt(codigo));

			if (result.isPresent())
				return ResponseEntity.ok(CustomResponseBuilder.buildSucesso(result.get()));
			else
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(CustomResponseBuilder.buildErro("Departamento não encontrado"));

		} catch (NumberFormatException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(CustomResponseBuilder.buildErro("Código inválido"));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(CustomResponseBuilder.buildErro(e.getMessage()));
		}
	}

	@GetMapping("/all")
	public ResponseEntity<CustomResponse> listarDepartamentos() {
		try {
			Command<List<DepartamentoEntity>> command = context.getBean(ListaDepartamento.class);
			return ResponseEntity.ok(CustomResponseBuilder.buildSucesso(command.executar()));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(CustomResponseBuilder.buildErro(e.getMessage()));
		}
	}

	@DeleteMapping
	public ResponseEntity<CustomResponse> excluirDepartamentoPorCodigo(@RequestParam(name = "code") String codigo) {
		try {
			Command<Void> command = context.getBean(ExcluiDepartamento.class);
			command.executar(Integer.parseInt(codigo));

			return ResponseEntity.ok(CustomResponseBuilder.buildSucesso(null, "Departamento excluído com sucesso"));

		} catch (NumberFormatException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(CustomResponseBuilder.buildErro("Código inválido"));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(CustomResponseBuilder.buildErro("Departamento não encontrado"));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(CustomResponseBuilder.buildErro(e.getMessage()));
		}
	}

	@PostMapping
	public ResponseEntity<CustomResponse> adicionarDepartamento(DepartamentoEntity entity) {
		try {
			if (!departamentoValidador.test(entity)) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(CustomResponseBuilder.buildErro("Dados de departamento incompletos"));
			}

			Command<Integer> command = context.getBean(AdicionaDepartamento.class);

			return ResponseEntity.status(HttpStatus.CREATED).body(CustomResponseBuilder
					.buildSucesso(command.executar(entity), "Departamento cadastrado com sucesso"));

		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(CustomResponseBuilder.buildErro("Departamento não encontrado"));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(CustomResponseBuilder.buildErro(e.getMessage()));
		}
	}

	@PutMapping
	public ResponseEntity<CustomResponse> alterarDepartamento(DepartamentoEntity entity) {
		try {
			if (!departamentoValidador.test(entity) && entity.getCodigo() == 0) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(CustomResponseBuilder.buildErro("Dados de departamento incompletos"));
			}

			Command<DepartamentoEntity> command = context.getBean(AlteraDepartamento.class);

			return ResponseEntity.status(HttpStatus.CREATED).body(
					CustomResponseBuilder.buildSucesso(command.executar(entity), "Departamento alterado com sucesso"));

		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(CustomResponseBuilder.buildErro("Departamento não encontrado"));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(CustomResponseBuilder.buildErro(e.getMessage()));
		}
	}

}
