package br.com.pcd.ejb.controller;

import javax.ejb.Remote;

@Remote
public interface UsuarioControllerRemote {

	public boolean login(String email, String senha);
	
}
