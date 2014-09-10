package br.com.caelum.loja.client.exemplo;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.Carrinho;

public class ClienteCarrinhoStateless {
	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();
		Carrinho carrinho = (Carrinho)ic.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/CarrinhoBeanStateless!br.com.caelum.loja.session.Carrinho");
		
		Livro l1 = new Livro();
		l1.setNome("Pais e Filhos");
		l1.setPreco(100.0);
		
		carrinho.addLivro(l1);
		
		for(Livro l:carrinho.getLivros()) {
			System.out.println(l.getNome());
		}

	}
}
