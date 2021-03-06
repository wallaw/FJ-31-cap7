
package br.com.caelum.loja.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ConsultaDeLivrosBean", targetNamespace = "http://ws.loja.caelum.com.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ConsultaDeLivrosBean {


    /**
     * 
     * @param nome
     * @return
     *     returns java.util.List<br.com.caelum.loja.ws.Livro>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscaLivro", targetNamespace = "http://ws.loja.caelum.com.br/", className = "br.com.caelum.loja.ws.BuscaLivro")
    @ResponseWrapper(localName = "buscaLivroResponse", targetNamespace = "http://ws.loja.caelum.com.br/", className = "br.com.caelum.loja.ws.BuscaLivroResponse")
    public List<Livro> buscaLivro(
        @WebParam(name = "nome", targetNamespace = "")
        String nome);

}
