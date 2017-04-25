package br.com.pcd.services.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.pcd.model.Produto;

@WebService
public interface ProdutoService {
	
	@WebMethod
	public Double retornaPreco(int id);
	
	@WebMethod
	public Produto retornaProduto(int id);
}
