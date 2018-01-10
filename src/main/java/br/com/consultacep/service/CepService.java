package br.com.consultacep.service;

import java.util.List;

import br.com.consultacep.exception.CEPNaoEncontradoException;
import br.com.consultacep.model.Cep;

/**
 * Interface para descrever os metodos do servico CEP
 * 
 * @author paulohms
 *
 */

public interface CepService {

	public Cep buscarPorCep(String cep) throws CEPNaoEncontradoException;

	public List<Cep> buscarPorEndereco(String endereco) throws CEPNaoEncontradoException;

}
