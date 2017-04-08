package br.com.pcd.controle;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.swing.text.TabableView;

import org.primefaces.component.tabview.TabView;

import br.com.pcd.dao.ProdutoDAO;
import br.com.pcd.ejb.controller.CategoriaController;
import br.com.pcd.ejb.controller.ProdutoController;
import br.com.pcd.model.Produto;



@ManagedBean
public class ProdutoMBean {

	TabView tabView;
	
	private Produto produto = new Produto();
	
	@EJB
	private ProdutoController controller;
	
	public List<Produto> getListaCompleta(){
		return controller.getListaCompleta();
	}
	
	public String selecionar(Produto produto){
		this.produto = produto;
		return "/admin/produto";
	}
	
	public String salvar(){
		try{
			//persiste  o produto no banco de dados
			controller.salvar(produto);
			
			//reiniciando o objeto
			produto = new Produto();
		}catch (Exception e) {
			System.out.println("Erro");
		}
		return null;
	}
	
	
	public String deletar(Produto produto){
		
		try{
			controller.deletar(produto);
			tabView.setActiveIndex(1);
			System.out.println("Registro deletado com sucesso");
		}catch (Exception e) {
			System.out.println("Erro");
		}
		
		return null;
	}
	
	
//	public String deletaraAjax(Produto produto){
//		ProdutoDAO dao = new ProdutoDAO();
//		try{
//			dao.delete(produto);
//			MensagemUTIL.addInfo("Registro deletado com sucesso");
//		}finally{
//			dao.close();  
//		}
//		return null;
//	}
//	
	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public TabView getTabView() {
		return tabView;
	}

	public void setTabView(TabView tabView) {
		this.tabView = tabView;
	}

	
}
