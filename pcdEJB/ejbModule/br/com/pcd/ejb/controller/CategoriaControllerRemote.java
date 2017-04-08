package br.com.pcd.ejb.controller;

import java.util.List;

import javax.ejb.Remote;

import br.com.pcd.model.Categoria;

@Remote
public interface CategoriaControllerRemote {

	public List<Categoria> getListaCompleta();

	public String salvar(Categoria cat);
	
	public String deletar(Categoria cat);
}
