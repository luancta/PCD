package br.com.pcd.controle;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.component.tabview.Tab;

import br.com.pcd.ejb.controller.CategoriaController;
import br.com.pcd.model.Categoria;

/**
 * Controla as operações relacionadas a categorias
 * @author Usuario
 *
 */

@ManagedBean
public class CategoriaMBean{

	
	private Categoria categoria = new Categoria();
	
	private Tab tabCadastro;
	
	@EJB
	private CategoriaController controller;

	/**
	 * Retorna a listagem todos os registros do banco
	 * @return
	 */
	public List<Categoria> getListaCompleta(){
		
		return controller.getListaCompleta();
	}
	
	
	/**
	 * Método que salva o objeto
	 * @return
	 */
	public String salvar(){
		try{
			controller.salvar(categoria);
			System.out.println("Categoria salva com sucesso");
		}catch (Exception e) {
			System.out.println("Erro ao salvar categoria.");
		}
		
		return null;
	}


	
	public String selecionar(Categoria categoria){
		this.categoria = categoria;
		tabCadastro.setInView(true);;
		return "/admin/categorrfrfia";
	}
	
	
	public String deletar(Categoria categoria){
		
		try{
			controller.deletar(categoria);
			System.out.println("Categoria removida com sucesso");
		}catch (Exception e) {
			System.out.println("Erro ao salvar categoria.");
		}
		
		return null;
	}

	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Tab getTabCadastro() {
		return tabCadastro;
	}


	public void setTabCadastro(Tab tabCadastro) {
		this.tabCadastro = tabCadastro;
	}
		
}
