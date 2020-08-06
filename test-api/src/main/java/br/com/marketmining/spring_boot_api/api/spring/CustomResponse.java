package br.com.marketmining.spring_boot_api.api.spring;

import java.util.ArrayList;
import java.util.List;

public class CustomResponse {
	private Object data;
	private Status status;
	private List<String> messages;

	public CustomResponse(Object data, Status status, List<String> messages) {
		this.data = data;
		this.status = status;
		this.messages = messages;
	}

	public CustomResponse(Object data, Status status, String message) {
		this.data = data;
		this.status = status;
		this.addMessage(message);
	}

	public void addMessage(String message) {
		if (messages == null)
			messages = new ArrayList<String>();
		messages.add(message);
	}

	public Object getData() {
		return data;
	}

	public Status getStatus() {
		return status;
	}

	public List<String> getMessages() {
		return messages;
	}

	public static enum Status {
		SUCESSO, ERRO

	}

}