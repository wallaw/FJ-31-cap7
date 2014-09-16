package br.com.caelum.loja.client.exemplo;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.Carrinho;

public class ClienteFinalizaCompra {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();
		
		Carrinho carrinho = (Carrinho) ic.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/CarrinhoBean!br.com.caelum.loja.session.Carrinho?stateful");
		
		Livro livro1 = new Livro();
		livro1.setNome("Deixados para trás");
		livro1.setPreco(45);
		
		Livro livro2 = new Livro();
		livro2.setNome("Deixados para trás 2");
		livro2.setPreco(54);
		
		carrinho.addLivro(livro1);	
		carrinho.addLivro(livro2);
		
		carrinho.finalizaCompra();
	}

}
