package br.com.pcd.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.DragDropEvent;

import br.com.pcd.model.Produto;

@ManagedBean
@SessionScoped
public class CarrinhoMBean {
	
	private List<Produto> itens = new ArrayList<Produto>();
	private Double valorTotal = 0.0;
	
	public void adicionar(DragDropEvent ddEvent){
		Produto produto = ((Produto) ddEvent.getData());
		itens.add(produto);
		calcularTotal();
	}
	
	public String remover(Produto produto){
		itens.remove(produto);
		calcularTotal();
		return null;
	}
	
	private void calcularTotal(){
		valorTotal = 0.0;
		for (Produto produto : itens) {
			valorTotal = Double.sum(valorTotal, produto.getPreco());
		}
	}
	
	public List<Produto> getItens() {
		return itens;
	}
	public void setItens(List<Produto> itens) {
		this.itens = itens;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
	
}
