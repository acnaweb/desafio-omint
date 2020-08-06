package br.com.marketmining.spring_boot_api.api.spring;

public final class CustomResponseBuilder {
	private static final String MESSAGE_SUCESSO = "Operação realizada com sucesso";

	public static CustomResponse buildSucesso(Object data, String message) {
		return new CustomResponse(data, CustomResponse.Status.SUCESSO, MESSAGE_SUCESSO);
	}

	public static CustomResponse buildSucesso(Object data) {
		return buildSucesso(data, MESSAGE_SUCESSO);
	}

	public static CustomResponse buildErro(String message) {
		return new CustomResponse(null, CustomResponse.Status.ERRO, message);
	}

}
