package br.com.pcd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.pcd.dao.PersistDB;

/**
 * Representa um produto disponível na loja
 * @author Luan
 */

@Entity
public class Produto implements PersistDB {
	
	/**
	 * Identificador único do produto no sistema
	 */
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * Denominação do produto, descreve-o de forma sucinta.
	 */
	private String denominacao;
	
	/**
	 * Descrição do produto, detalhes sobre o produto
	 */
	private String descricao;
	
	/**
	 * Preço do produto
	 */
	private Double preco;
	
	/**
	 * Categoria da qual o produto pertence
	 */
	@ManyToOne
	private Categoria categoria = new Categoria();
	
	/**
	 * Construtor padrão
	 */
	public Produto() {
		super();
	}
	
	/**
	 * Construtor recebendo apenas o id
	 * @param id
	 */
	public Produto(int id) {
		super();
		this.id = id;
	}
	
	/**
	 * Construtor recebendo todos os atributos.
	 * @param id
	 * @param denominacao
	 * @param descricao
	 * @param preco
	 */
	public Produto(int id, String denominacao, String descricao, Double preco) {
		super();
		this.id = id;
		this.denominacao = denominacao;
		this.descricao = descricao;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDenominacao() {
		return denominacao;
	}

	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	} 
	
}