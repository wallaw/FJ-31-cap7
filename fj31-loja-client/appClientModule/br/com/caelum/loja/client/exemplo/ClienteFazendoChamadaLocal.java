package br.com.caelum.loja.client.exemplo;

import javax.naming.InitialContext;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.Carrinho;

public class ClienteFazendoChamadaLocal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Livro livro = new Livro();
		
		long inicio = System.currentTimeMillis();
		for(int i=0; i<10000; i++) {
			livro.getPreco();
		}
		
		long fim = System.currentTimeMillis();
		System.out.println(fim-inicio);

	}

}
