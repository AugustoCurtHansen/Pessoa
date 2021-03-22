package br.com.formularioPessoa.Controller.DTO;

import java.util.List;
import java.util.stream.Collectors;

import br.com.formularioPessoa.modelo.Pessoa;

public class PessoaDTO {
	
	private String nome; 
	private String sobrenome; 
	private String idade; 
	private String sexo; 
	
	public PessoaDTO(Pessoa usuario) {
		this.nome = usuario.getNome();
		this.sobrenome = usuario.getSobrenome();
		this.idade = usuario.getIdade();
		this.sexo = usuario.getSexo();
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * @return the idade
	 */
	public String getIdade() {
		return idade;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	public static List<PessoaDTO> converter(List<Pessoa> pessoas) {
		return pessoas.stream().map(PessoaDTO::new).collect(Collectors.toList());
	} 
}