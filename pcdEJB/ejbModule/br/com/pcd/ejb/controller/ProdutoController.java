package br.com.pcd.ejb.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.pcd.dao.CategoriaDAO;
import br.com.pcd.dao.ProdutoDAO;
import br.com.pcd.model.Produto;


@Stateless
@LocalBean
public class ProdutoController implements ProdutoControllerRemote, ProdutoControllerLocal {

	@PersistenceContext(unitName="PostgresDS")
	EntityManager em;

	private ProdutoDAO produtoDAO;

	private Produto produto;
	
	@PostConstruct
	public void init(){
		this.setProdutoDAO(new ProdutoDAO(em));
		this.produto = new Produto();
	}
	
	/**
	 * Retorna a listagem todos os registros do banco
	 * @return
	 */
	public List<Produto> getListaCompleta(){
		
		ProdutoDAO dao = new ProdutoDAO(em);
		
		try{
			return dao.findAll();
		}finally{
			dao.close();
		}
	}
	
	/**
	 * Método que salva o objeto
	 * @return
	 */
	public String salvar(Produto prod){
		produto = prod;
		ProdutoDAO dao = new ProdutoDAO(em);
		CategoriaDAO catDao = new CategoriaDAO(em);
		try{
			//persiste  o produto no banco de dados
			if(produto.getId() > 0){
				dao.update(produto);
			}else{
				dao.create(produto);
			}
			
			//recarrega as informacoes da categoria
			produto.setCategoria( catDao.findByPrimaryKey(
									Integer.valueOf( produto.getCategoria().getId() )));
			
			//mensagem de sucesso
			System.out.println("produto salvo com sucesso");
			
			//reiniciando o objeto
			produto = new Produto();
		} catch (Exception e) {
			System.out.println("Erro ao salvar o produto");
		}
		finally{
			dao.close();
			catDao.close();
		}
		return null;
	}
	
	public String deletar(Produto prod){
		produto = prod;
		ProdutoDAO dao = new ProdutoDAO(em);
		try{
			dao.delete(produto);
			System.out.println("Registro deletado com sucesso");
		}finally{
			dao.close();
		}
		
		return null;
	}

	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}

	
}
