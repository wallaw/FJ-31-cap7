package br.com.caelum.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.WebParam;

@WebService
public class CalculadorDeParcela {
	
	@WebMethod
	public double calculaParcela(
			@WebParam(name="valorTotal") double valorTotal,
			@WebParam(name="quantidade") int quantidade) {
		if (quantidade <0) {
			return 0;
		}
		double oValorTotal = valorTotal*(1+(quantidade/100.0));
		return oValorTotal/quantidade;
	}
}
