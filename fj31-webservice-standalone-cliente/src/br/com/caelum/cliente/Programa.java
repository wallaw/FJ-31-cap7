package br.com.caelum.cliente;

public class Programa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CalculadorDeParcela calculador = new CalculadorDeParcelaService().getCalculadorDeParcelaPort();
		System.out.println(calculador.calculaParcela(100, 2));

	}

}
