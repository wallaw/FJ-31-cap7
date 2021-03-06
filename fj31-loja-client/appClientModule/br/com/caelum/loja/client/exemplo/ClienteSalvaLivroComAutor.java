package br.com.caelum.loja.client.exemplo;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.caelum.loja.entity.Autor;
import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.GerenciadorLoja;

public class ClienteSalvaLivroComAutor {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();
		
		GerenciadorLoja gerenciador = (GerenciadorLoja) ic.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/GerenciadorLojaBean!br.com.caelum.loja.session.GerenciadorLoja");
		
		Livro livro = new Livro();
		Autor autor = new Autor();
		
		autor.setNome("Nome do autor");
		
		autor = gerenciador.salva(autor);
		System.out.println("Id do autor: " +autor.getId());
		
		livro.getAutores().add(autor);
		
		livro.setNome("Pais e Filhos");
		livro.setPreco(25);
		
		gerenciador.salva(livro);

	}

}
