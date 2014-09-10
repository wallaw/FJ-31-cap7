package br.com.caelum.loja.session;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.Remote;
import javax.ejb.StatefulTimeout;
import java.util.concurrent.TimeUnit;

import org.jboss.ejb3.annotation.Cache;

import br.com.caelum.loja.entity.Livro;

@Stateful
@Remote(Carrinho.class)
public class CarrinhoBean implements Carrinho {

	private double total;
	private List<Livro> livros = new ArrayList<Livro>();

	@EJB
	private Mensageiro mensageiro;
	
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
	@Remove
	public void finalizaCompra() {
		for (Livro livro : this.livros) {
			System.out.println("Comprando livro: " + livro.getNome());
		}
		this.mensageiro.enviaMensagem(this.livros);
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Removendo uma instancia de CarrinhoBean do Container");
	}
	
	@PostActivate
	public void ativando(){
		System.out.println("Ativando" +this);
	}
	
	@PrePassivate
	public void passivando(){
		System.out.println("Passivando "+this);
	}
}
