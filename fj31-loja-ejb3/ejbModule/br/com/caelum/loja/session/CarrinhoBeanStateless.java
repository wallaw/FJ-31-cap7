package br.com.caelum.loja.session;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.Remote;
import javax.ejb.StatefulTimeout;
import javax.ejb.Stateless;

import java.util.concurrent.TimeUnit;

import org.jboss.ejb3.annotation.Cache;
import org.jboss.ejb3.annotation.Pool;

import br.com.caelum.loja.entity.Livro;

@Stateless
@Pool("slsb-strict-max-pool")
@Remote(Carrinho.class)
@Cache("passivating")
@StatefulTimeout(value=20, unit= TimeUnit.SECONDS)
public class CarrinhoBeanStateless implements Carrinho {

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
	@Remove
	public void finalizaCompra() {
		for (Livro livro : this.livros) {
			System.out.println("Comprando livro: " + livro.getNome());
		}
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
