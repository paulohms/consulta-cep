package br.com.consultacep.enums;

/**
 * Ligacao com o indice para extrair as informacoes do HTML
 * 
 * @author paulohms
 *
 */
public enum TipoAtributoEnum {

	ENDERECO(0), BAIRRO(1), LOCALIDADE(2), CEP(3);

	TipoAtributoEnum(Integer index) {
		this.index = index;
	}

	private Integer index;

	public Integer getIndex() {
		return index;
	}

}