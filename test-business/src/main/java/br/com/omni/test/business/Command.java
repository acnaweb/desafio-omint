package br.com.omni.test.business;

public interface Command<T> {
	public T executar(Object... params) throws Exception;
}
