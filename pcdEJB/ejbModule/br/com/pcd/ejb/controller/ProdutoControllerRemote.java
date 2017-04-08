package br.com.pcd.ejb.controller;

import java.util.List;

import javax.ejb.Remote;

import br.com.pcd.model.Produto;

@Remote
public interface ProdutoControllerRemote {

	public List<Produto> getListaCompleta();

	public String salvar(Produto prod);
	
	public String deletar(Produto prod);
}
