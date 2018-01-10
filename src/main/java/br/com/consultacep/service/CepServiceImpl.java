package br.com.consultacep.service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import br.com.consultacep.enums.TipoAtributoEnum;
import br.com.consultacep.exception.CEPNaoEncontradoException;
import br.com.consultacep.model.Cep;

/**
 * Classe responsavel pelas implementacoes da busca de CEP
 * 
 * @author paulohms
 *
 */
@Component
public class CepServiceImpl implements CepService {

	public static final String BASE_URL = "http://www.buscacep.correios.com.br/sistemas/buscacep/resultadoBuscaCepEndereco.cfm";;

	/**
	 * Busca informacoes do CEP pelo numero do CEP
	 * 
	 * @throws CEPNaoEncontradoException
	 * @throws @throws
	 *             NumberFormatException
	 */
	public Cep buscarPorCep(String cep) throws CEPNaoEncontradoException {

		Document doc;

		try {
			doc = Jsoup.connect(BASE_URL).data("relaxation", cep, "tipoCEP", "ALL").post();
		} catch (IOException e) {
			throw new CEPNaoEncontradoException(cep);
		}

		Elements element = doc.getElementsByClass("tmptabela");

		if (element == null || element.size() == 0)
			throw new CEPNaoEncontradoException(cep);

		Elements colunas = element.get(0).getElementsByTag("td");

		return new Cep(getAttribute(colunas, TipoAtributoEnum.ENDERECO), getAttribute(colunas, TipoAtributoEnum.BAIRRO),
				getAttribute(colunas, TipoAtributoEnum.LOCALIDADE), getAttribute(colunas, TipoAtributoEnum.CEP));

	}

	/**
	 * Busca informacoes do CEP pelo Endereco
	 */
	public List<Cep> buscarPorEndereco(String endereco) throws CEPNaoEncontradoException {

		List<Cep> ceps = new ArrayList<Cep>();

		Document doc;
		try {
			doc = Jsoup.connect(BASE_URL).data("relaxation", URLEncoder.encode(endereco, "ISO-8859-1"), "tipoCEP", "ALL").post();
		} catch (IOException e) {
			throw new CEPNaoEncontradoException(endereco, null);
		}

		Elements elementos = doc.getElementsByTag("tr");

		if (elementos == null || elementos.size() == 0)
			throw new CEPNaoEncontradoException(endereco);

		for (Element element : elementos) {

			Elements currentColuns = element.getElementsByTag("td");

			if(currentColuns.size() == 0)
				continue;

			ceps.add(new Cep(getAttribute(currentColuns, TipoAtributoEnum.ENDERECO),
					getAttribute(currentColuns, TipoAtributoEnum.BAIRRO),
					getAttribute(currentColuns, TipoAtributoEnum.LOCALIDADE),
					getAttribute(currentColuns, TipoAtributoEnum.CEP)));

		}

		return ceps;

	}

	private String getAttribute(Elements colunas, TipoAtributoEnum tipoAtributoEnum) {
		return colunas.get(tipoAtributoEnum.getIndex()).text();
	}

}
