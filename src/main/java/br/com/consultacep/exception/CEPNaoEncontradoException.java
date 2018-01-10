package br.com.consultacep.exception;

import java.io.IOException;

/**
 * Exception lancada quando uma busca de CEP/Endereco nao retorna nada.
 * 
 * @author paulohms
 *
 */
public class CEPNaoEncontradoException extends IOException {

	private static final long serialVersionUID = 1L;

	public CEPNaoEncontradoException(String numeroCEP) {
		super("O CEP " + numeroCEP + " não foi encontrado.");
	}

	public CEPNaoEncontradoException(String query, Throwable cause) {
		super("Busca por '" + query + "' não encontrou nada.", cause);
	}

}