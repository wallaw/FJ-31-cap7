package br.com.caelum.fj31.jaxb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class TesteMarshal {

	/**
	 * @param args
	 * @throws JAXBException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws JAXBException, IOException {
		Produto produto = new Produto();
		produto.setNome("bola");
		produto.setPreco(20.34);
		produto.setDescricao("uma bola quadrada");
		
		Categoria categoria = new Categoria();
		categoria.setNome("esporte");
		produto.setCategoria(categoria);
		
		JAXBContext context = JAXBContext.newInstance(Produto.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(produto, new FileOutputStream("bola.xml"));
	}

}
