package br.com.caelum.loja.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Remote;

import br.com.caelum.loja.entity.Livro;

@Stateful
@Remote(Carrinho.class)
public class CarrinhoBean implements Carrinho {

	private double total;
	private List<Livro> livros = new ArrayList<Livro>();

	@Override
	public void addLivro(Livro livro) {
		this.livros.add(livro);
		this.total += livro.getPreco();
		
		System.out.printf("Livro %s adicionado com sucesso\n", livro.getNome());
	}

	@Override
	public List<Livro> getLivros() {
		return this.livros;
	}

	@Override
	public double getTotal() {
		return this.total;
	}

	@Override
	public void finalizaCompra() {
		for (Livro livro : this.livros) {
			System.out.println("Comprando livro: " + livro.getNome());
		}
	}
	
}
