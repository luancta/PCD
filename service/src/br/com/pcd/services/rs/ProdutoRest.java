package br.com.pcd.services.rs;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.pcd.ejb.controller.ProdutoController;
import br.com.pcd.model.Produto;


@Path("/produto")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class ProdutoRest {
	
	
	@EJB
	private ProdutoController controller;
	
	@GET
	public List<Produto> getAll(){
		return controller.getProdutoDAO().findAll();
	}
	
	@GET
	@Path("{id}")
	public Response get (@PathParam("id") int id){
		Produto produto = controller.getProdutoDAO().findByPrimaryKey(id);
		return Response.status(200).entity(produto).build();
	}
}
