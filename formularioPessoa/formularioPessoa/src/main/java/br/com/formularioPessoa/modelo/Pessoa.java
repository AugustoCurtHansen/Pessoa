package br.com.formularioPessoa.modelo;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Pessoa {
	// nome, sobrenome,  idade e sexo
	@Id  
	private String nome; 
	private String sobrenome; 
	private String idade; 
	private String sexo; 
	
	public Pessoa() {
		
	}

	/**
	 * @param nome
	 * @param sobrenome
	 * @param idade
	 * @param sexo
	 */
	public Pessoa(String nome, String sobrenome, String idade, String sexo) {
		setNome(nome);
		setSobrenome(sobrenome);
		setIdade(idade);
		setSexo(sexo);
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * @param sobrenome the sobrenome to set
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	/**
	 * @return the idade
	 */
	public String getIdade() {
		return idade;
	}

	/**
	 * @param idade the idade to set
	 */
	public void setIdade(String idade) {
		this.idade = idade;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}