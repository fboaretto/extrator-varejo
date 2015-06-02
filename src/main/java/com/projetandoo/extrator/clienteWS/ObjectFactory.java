
package com.projetandoo.extrator.clienteWS;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.projetandoo.extrator.clienteWS package. 
 * <p>An ObjectFactory allows you to programmatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SalvarResponse_QNAME = new QName("http://service.varejodigital.projetandoo/1.0/", "salvarResponse");
    private final static QName _Salvar_QNAME = new QName("http://service.varejodigital.projetandoo/1.0/", "salvar");

    /**
     * Create a new ObjectFactory that can be used to create 
     * new instances of schema derived classes for package: 
     * com.projetandoo.extrator.clienteWS
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SalvarResponse }
     * 
     */
    public SalvarResponse createSalvarResponse() {
        return new SalvarResponse();
    }

    /**
     * Create an instance of {@link Salvar }
     * 
     */
    public Salvar createSalvar() {
        return new Salvar();
    }

    /**
     * Create an instance of {@link FornecedorType }
     * 
     */
    public FornecedorType createFornecedorType() {
        return new FornecedorType();
    }

    /**
     * Create an instance of {@link DepartamentoType }
     * 
     */
    public DepartamentoType createDepartamentoType() {
        return new DepartamentoType();
    }

    /**
     * Create an instance of {@link LojaType }
     * 
     */
    public LojaType createLojaType() {
        return new LojaType();
    }

    /**
     * Create an instance of {@link ProdutoResponseType }
     * 
     */
    public ProdutoResponseType createProdutoResponseType() {
        return new ProdutoResponseType();
    }

    /**
     * Create an instance of {@link GondolaType }
     * 
     */
    public GondolaType createGondolaType() {
        return new GondolaType();
    }

    /**
     * Create an instance of {@link EstoqueType }
     * 
     */
    public EstoqueType createEstoqueType() {
        return new EstoqueType();
    }

    /**
     * Create an instance of {@link ProdutoType }
     * 
     */
    public ProdutoType createProdutoType() {
        return new ProdutoType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SalvarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.varejodigital.projetandoo/1.0/", name = "salvarResponse")
    public JAXBElement<SalvarResponse> createSalvarResponse(SalvarResponse value) {
        return new JAXBElement<SalvarResponse>(_SalvarResponse_QNAME, SalvarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Salvar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.varejodigital.projetandoo/1.0/", name = "salvar")
    public JAXBElement<Salvar> createSalvar(Salvar value) {
        return new JAXBElement<Salvar>(_Salvar_QNAME, Salvar.class, null, value);
    }

}
