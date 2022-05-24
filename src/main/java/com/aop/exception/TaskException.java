package com.aop.exception;

import java.util.Objects;

import org.springframework.http.HttpStatus;

public class TaskException extends RuntimeException {

	private static final long serialVersionUID = 8997691658158725204L;
	
	private String message;
	private HttpStatus httpStatus;
	
	public TaskException(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(httpStatus, message);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskException other = (TaskException) obj;
		return httpStatus == other.httpStatus && Objects.equals(message, other.message);
	}

	@Override
	public String toString() {
		return "TaskException [message=" + message + ", httpStatus=" + httpStatus + "]";
	}

}
