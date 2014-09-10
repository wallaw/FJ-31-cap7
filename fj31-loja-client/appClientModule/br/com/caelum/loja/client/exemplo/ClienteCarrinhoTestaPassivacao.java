package br.com.caelum.loja.client.exemplo;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.Carrinho;

public class ClienteCarrinhoTestaPassivacao {
	public static void main(String[] args) throws NamingException, InterruptedException {
		InitialContext ic = new InitialContext();
		Carrinho primeiroCarrinho = (Carrinho)ic.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/CarrinhoBean!br.com.caelum.loja.session.Carrinho?stateful");
		
		Livro l1 = new Livro();
		l1.setNome("Fausto");
		l1.setPreco(45);
		
		primeiroCarrinho.addLivro(l1);
		
		for(int i=0; i<50;i++){
			Carrinho carrinho = (Carrinho)ic.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/CarrinhoBean!br.com.caelum.loja.session.Carrinho?stateful");
			carrinho.addLivro(l1);
		}
		
		
		primeiroCarrinho.addLivro(l1);
		Thread.sleep(120);
		primeiroCarrinho.addLivro(l1);
	}
}
