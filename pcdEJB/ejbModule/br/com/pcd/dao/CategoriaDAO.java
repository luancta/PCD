package br.com.pcd.dao;

import javax.persistence.EntityManager;

import br.com.pcd.model.Categoria;

/**
 * Responsável por executar o acesso a dados da Entidade Categoria.
 * @author Usuario
 *
 */
public class CategoriaDAO extends GenericDAO<Categoria>{
	
	EntityManager entityManager;
	
	public CategoriaDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Class<Categoria> getClassType() {
		return Categoria.class;
	}

	@Override
	public EntityManager getEm() {
		return entityManager;
	}
	
	

}
