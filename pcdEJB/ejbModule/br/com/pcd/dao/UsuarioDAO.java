package br.com.pcd.dao;

import javax.persistence.EntityManager;

import br.com.pcd.model.Usuario;


public class UsuarioDAO extends GenericDAO<Usuario> {

	EntityManager entityManager;
	
	public UsuarioDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public Class<Usuario> getClassType() {
		return Usuario.class;
	}

	@Override
	public EntityManager getEm() {
		return entityManager;
	}

}
