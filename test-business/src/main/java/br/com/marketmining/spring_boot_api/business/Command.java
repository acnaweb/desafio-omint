package br.com.marketmining.spring_boot_api.business;

public interface Command<T> {
	public T executar(Object... params) throws Exception;
}
