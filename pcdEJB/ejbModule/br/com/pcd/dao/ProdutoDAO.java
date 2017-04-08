package br.com.pcd.dao;

import javax.persistence.EntityManager;

import br.com.pcd.model.Produto;

/**
 * Responsável por executar o acesso a dados da Entidade Produto.
 * @author Usuario
 *
 */
public class ProdutoDAO extends GenericDAO<Produto>{

	EntityManager entityManager;
	
	public ProdutoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public Class<Produto> getClassType() {
		return Produto.class;
	}

	@Override
	public EntityManager getEm() {
		return entityManager;
	}
	
	

}
