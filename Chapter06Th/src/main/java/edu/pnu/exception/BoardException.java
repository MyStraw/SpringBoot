package edu.pnu.exception;

//실행시점에서 발생하는 익셉션 잡아
public class BoardException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public BoardException(String message) {
		super(message);
	}
}
