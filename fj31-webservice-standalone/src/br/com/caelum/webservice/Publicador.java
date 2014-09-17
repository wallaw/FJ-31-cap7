package br.com.caelum.webservice;
import javax.xml.ws.Endpoint;

import br.com.caelum.webservice.CalculadorDeParcela;


public class Publicador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:10000/calculadorDeParcela", new CalculadorDeParcela());

	}

}
