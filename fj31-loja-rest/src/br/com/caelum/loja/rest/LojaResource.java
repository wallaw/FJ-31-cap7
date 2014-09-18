package br.com.caelum.loja.rest;

import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.GerenciadorLoja;

@Path("/loja")
public class LojaResource {
	@EJB
	GerenciadorLoja gerenciador;
	
	@GET @Path("/livros")
	@Produces("application/xml")
	public List<Livro> getLivrosXml(){
		List<Livro> livros = gerenciador.listaLivros();
		return livros;
	}
	
	
	@POST
	@Path("/livros")
	@Consumes({"application/xml","application/json"})
	public Response cadastra(Livro livro) {
		Livro salvo = gerenciador.salva(livro);
		System.out.println("Nome: "+salvo.getNome());
		return Response.created(URI.create("/loja/livro/"+salvo.getId())).build();
	}

}
