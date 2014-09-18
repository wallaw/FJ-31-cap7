package br.com.caelum.loja.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
}
