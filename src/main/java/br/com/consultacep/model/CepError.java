package br.com.consultacep.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;

/**
 * Classe para representar um objeto de erro do retorno
 * 
 * @author paulohms
 *
 */
public class CepError {

	private HttpStatus status;
	private String message;

	public CepError() {
		status = HttpStatus.NOT_FOUND;
		this.message = "Cep ou endereço não encontrado";
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getTimestamp() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
		return LocalDateTime.now().format(formatter);
	}

	public String getMessage() {
		return message;
	}

}