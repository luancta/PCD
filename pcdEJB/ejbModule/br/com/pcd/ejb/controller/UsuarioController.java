package br.com.pcd.ejb.controller;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.pcd.dao.UsuarioDAO;
import br.com.pcd.model.Usuario;


@Stateless
@LocalBean
public class UsuarioController implements UsuarioControllerRemote, UsuarioControllerLocal {

	@PersistenceContext(unitName="PostgresDS")
	EntityManager em;

	private UsuarioDAO usuarioDAO;

	private Usuario usuario;
	
	@PostConstruct
	public void init(){
		this.usuarioDAO = new UsuarioDAO(em);
		this.usuario = new Usuario();
	}
	
	
	public boolean login(String email, String senha) {
		Usuario user = new Usuario();
		Collection<Usuario> users = new ArrayList<>();
		users = usuarioDAO.findAllLike("email", email);
		
		if (!users.isEmpty()){
			for (Usuario u : users) {
				if(u.getEmail().equals(email) && u.getSenha().equals(senha)) {
					user = u;
					System.out.println("EJB: usuario encontrado: " + email + " - " + senha);
					break;
				}
			}
		} else {
			usuarioDAO.create(new Usuario(email, senha));
			user = usuarioDAO.findAllLike("email", email).get(0);
		} 
		
		if (user.getEmail().equals(email) && user.getSenha().equals(senha)){
			return true;
		}
			
		System.out.println("EJB: não foi possivel fazer login com: " + email + " - " + senha);
		return false;
	}

	public void login() {
//		usuarioDAO.create(new Usuario(email, senha));
		System.out.println("EJB: tentando fazer login com: " + usuario.getEmail() + " - " + usuario.getSenha());
	}

}
