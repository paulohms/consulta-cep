package br.com.consultacep.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.consultacep.exception.CEPNaoEncontradoException;
import br.com.consultacep.model.Cep;
import br.com.consultacep.model.CepError;
import br.com.consultacep.service.CepService;

/**
 * Controller da aplicacao
 * 
 * @author paulohms
 *
 */
@RestController
public class CepController {

	@Autowired
	CepService cepService;

	@RequestMapping(value = "/consultarPorCep", method = RequestMethod.GET)
	public Cep consultarPorCep(@RequestParam(required = true) String cep) throws CEPNaoEncontradoException {
		return cepService.buscarPorCep(cep);
	}

	@RequestMapping(value = "/consultarPorEndereco", method = RequestMethod.GET)
	public List<Cep> consultarPorEndereco(@RequestParam(required = true) String endereco) throws IOException {
		return cepService.buscarPorEndereco(endereco);
	}

	@ExceptionHandler({ CEPNaoEncontradoException.class })
	public CepError handleException() {
		return new CepError();
	}

}