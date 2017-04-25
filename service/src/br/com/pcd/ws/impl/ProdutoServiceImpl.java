package br.com.pcd.ws.impl;

import javax.ejb.EJB;
import javax.jws.WebService;

import br.com.pcd.ejb.controller.ProdutoController;
import br.com.pcd.model.Produto;
import br.com.pcd.services.ws.ProdutoService;


@WebService(serviceName="UsuarioService")
public class ProdutoServiceImpl implements ProdutoService{
	
	@EJB
	private ProdutoController controller;

	@Override
	public Double retornaPreco(int id) {
		Produto produto = controller.getProdutoDAO().findByPrimaryKey(id);
		if(produto != null)
			return produto.getPreco();
		else
			return null;
	}

	@Override
	public Produto retornaProduto(int id) {
		Produto produto = controller.getProdutoDAO().findByPrimaryKey(id);
		return produto;
	}

}
