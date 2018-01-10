package br.com.consultacep.model;

/**
 * Bean para representar um CEP
 * 
 * @author paulohms
 *
 */
public class Cep {

	private String endereco;
	private String bairro;
	private String localidade;
	private String cep;

	public Cep() {

	}

	public Cep(String endereco, String bairro, String localidade, String cep) {
		super();
		this.endereco = endereco;
		this.bairro = bairro;
		this.localidade = localidade;
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Cep [endereco=" + endereco + ", bairro=" + bairro + ", localidade=" + localidade + ", cep=" + cep + "]";
	}

}
