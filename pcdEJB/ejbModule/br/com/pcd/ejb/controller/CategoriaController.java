package br.com.pcd.ejb.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.pcd.dao.CategoriaDAO;
import br.com.pcd.model.Categoria;


@Stateless
@LocalBean
public class CategoriaController implements CategoriaControllerRemote, CategoriaControllerLocal {

	@PersistenceContext(unitName="PostgresDS")
	EntityManager em;

	private CategoriaDAO categoriaDAO;

	private Categoria categoria;
	
	@PostConstruct
	public void init(){
		this.setCategoriaDAO(new CategoriaDAO(em));
		this.categoria = new Categoria();
	}
	
	/**
	 * Retorna a listagem todos os registros do banco
	 * @return
	 */
	public List<Categoria> getListaCompleta(){
		
		CategoriaDAO dao = new CategoriaDAO(em);
		
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
	public String salvar(Categoria cat){
		categoria = cat;
		CategoriaDAO dao = new CategoriaDAO(em);
		try{
			if (categoria.getId()==0 ){
				dao.create(categoria);
				categoria  = new Categoria();
			}else{
				dao.update(categoria);
			}
			System.out.println("Categoria salva com sucesso");
		}finally{
			dao.close();  
		}
		
		return null;
	}
	
	public String deletar(Categoria cat){
		categoria = cat;
		CategoriaDAO dao = new CategoriaDAO(em);
		try{
			dao.delete(categoria);
			System.out.println("Registro deletado com sucesso");
		}finally{
			dao.close();
		}
		
		return null;
	}

	public CategoriaDAO getCategoriaDAO() {
		return categoriaDAO;
	}

	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}

	
}
