package br.com.caelum.loja.client.exemplo;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.GerenciadorLoja;

public class ClienteTestaTransacaoException {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();
		GerenciadorLoja gerenciador = (GerenciadorLoja) ic.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/GerenciadorLojaBean!br.com.caelum.loja.session.GerenciadorLoja");
		Livro livro = new Livro();
		livro.setNome("Deixados para trás");
		gerenciador.salva(livro);
	}

}
