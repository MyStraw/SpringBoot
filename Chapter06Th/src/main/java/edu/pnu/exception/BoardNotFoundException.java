package edu.pnu.exception;

//굳이 앞에 만든 보드익셉션을 상속받네
public class BoardNotFoundException extends BoardException {
	private static final long serialVersionUID = 1L;

	public BoardNotFoundException(String message) {
		super(message);
	}
}
