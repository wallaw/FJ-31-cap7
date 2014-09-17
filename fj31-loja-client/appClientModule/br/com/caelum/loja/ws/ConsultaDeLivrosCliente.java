package br.com.caelum.loja.ws;

import java.util.ArrayList;
import java.util.List;

public class ConsultaDeLivrosCliente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConsultaDeLivrosBean consulta = new ConsultaDeLivrosBeanService().getConsultaDeLivrosBeanPort();
		List<Livro> list = (ArrayList<Livro>) consulta.buscaLivro("Deixados");
		for(int i=0; i<list.size();i++)
			System.out.println(list.get(i).getNome());

	}

}
