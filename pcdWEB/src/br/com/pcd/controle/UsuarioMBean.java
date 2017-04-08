package br.com.pcd.controle;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.pcd.ejb.controller.UsuarioController;
import br.com.pcd.model.Usuario;

@SessionScoped
@ManagedBean
public class UsuarioMBean{
	
	private Usuario obj = new Usuario();
	
	@EJB
	private UsuarioController controller;
	
	
	public String login(){
		if(controller.login(obj.getEmail(), obj.getSenha()))
			return "/loja.xhtml";
		else 
			return null;
	}
	
	public Usuario getObj() {
		return obj;
	}

	public void setObj(Usuario obj) {
		this.obj = obj;
	}	
}

