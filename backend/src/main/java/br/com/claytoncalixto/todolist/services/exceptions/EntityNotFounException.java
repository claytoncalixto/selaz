package br.com.claytoncalixto.todolist.services.exceptions;

public class EntityNotFounException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EntityNotFounException(String msg) {
		super(msg);
	}
}
