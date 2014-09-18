package br.com.caelum.loja.client;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ClienteRestGetLivroPelaId {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet get = new HttpGet("http://localhost:8080/fj31-loja-rest/loja/livro/4");
		get.addHeader("accept", "application/xml");
		
		HttpResponse response = httpClient.execute(get);

	}

}
