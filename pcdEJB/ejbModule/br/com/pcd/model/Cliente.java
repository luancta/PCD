package br.com.pcd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.pcd.dao.PersistDB;

/**
 * Representa o cliente, que faz as compras no sistema
 * @author Luan
 *
 */
@Entity
public class Cliente implements PersistDB {

	/**
	 * Identificador unico do cliente no sistema
	 */
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * Nome do cliente
	 */
	private String nome;
	
	/**
	 * Email do cliente,também usado para efetuar login no sistema.
	 */
	private String email;
	
	/**
	 * Cpf do cliente
	 */
	private String cpf;
	
	/**
	 * Senha usada para acesso do cliente no sistema
	 */
	private String senha;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
