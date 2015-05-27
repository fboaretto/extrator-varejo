
package com.projetandoo.wsdl;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProdutoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProdutoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="loja" type="{http://schema.varejodigital.projetandoo/1.0/}LojaType"/>
 *         &lt;element name="departamanento" type="{http://schema.varejodigital.projetandoo/1.0/}DepartamentoType" minOccurs="0"/>
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="preco" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="custo" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="peso" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="estoque" type="{http://schema.varejodigital.projetandoo/1.0/}EstoqueType"/>
 *         &lt;element name="codigoBarra" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codigoInterno" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="codigoExterno" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProdutoType", propOrder = {
    "loja",
    "departamanento",
    "nome",
    "preco",
    "custo",
    "peso",
    "estoque",
    "codigoBarra",
    "codigoInterno",
    "codigoExterno"
})
public class ProdutoType {

    @XmlElement(required = true)
    protected LojaType loja;
    
    protected DepartamentoType departamanento;
    
    @XmlElement(required = true)
    protected String nome;
    
    @XmlElement(required = true)
    protected BigDecimal preco;
    
    @XmlElement(required = true)
    protected BigDecimal custo;
    
    @XmlElement(required = true)
    protected BigDecimal peso;
    
    @XmlElement(required = true)
    protected EstoqueType estoque;
    
    @XmlElement(required = true)
    protected String codigoBarra;
    
    protected long codigoInterno;
    
    protected long codigoExterno;

    /**
     * Gets the value of the loja property.
     * 
     * @return
     *     possible object is
     *     {@link LojaType }
     *     
     */
    public LojaType getLoja() {
        return loja;
    }

    /**
     * Sets the value of the loja property.
     * 
     * @param value
     *     allowed object is
     *     {@link LojaType }
     *     
     */
    public void setLoja(LojaType value) {
        this.loja = value;
    }

    /**
     * Gets the value of the departamanento property.
     * 
     * @return
     *     possible object is
     *     {@link DepartamentoType }
     *     
     */
    public DepartamentoType getDepartamanento() {
        return departamanento;
    }

    /**
     * Sets the value of the departamanento property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepartamentoType }
     *     
     */
    public void setDepartamanento(DepartamentoType value) {
        this.departamanento = value;
    }

    /**
     * Gets the value of the nome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the value of the nome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Gets the value of the preco property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPreco() {
        return preco;
    }

    /**
     * Sets the value of the preco property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPreco(BigDecimal value) {
        this.preco = value;
    }

    /**
     * Gets the value of the custo property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCusto() {
        return custo;
    }

    /**
     * Sets the value of the custo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCusto(BigDecimal value) {
        this.custo = value;
    }

    /**
     * Gets the value of the peso property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPeso() {
        return peso;
    }

    /**
     * Sets the value of the peso property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPeso(BigDecimal value) {
        this.peso = value;
    }

    /**
     * Gets the value of the estoque property.
     * 
     * @return
     *     possible object is
     *     {@link EstoqueType }
     *     
     */
    public EstoqueType getEstoque() {
        return estoque;
    }

    /**
     * Sets the value of the estoque property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstoqueType }
     *     
     */
    public void setEstoque(EstoqueType value) {
        this.estoque = value;
    }

    /**
     * Gets the value of the codigoBarra property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoBarra() {
        return codigoBarra;
    }

    /**
     * Sets the value of the codigoBarra property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoBarra(String value) {
        this.codigoBarra = value;
    }

    /**
     * Gets the value of the codigoInterno property.
     * 
     */
    public long getCodigoInterno() {
        return codigoInterno;
    }

    /**
     * Sets the value of the codigoInterno property.
     * 
     */
    public void setCodigoInterno(long value) {
        this.codigoInterno = value;
    }

    /**
     * Gets the value of the codigoExterno property.
     * 
     */
    public long getCodigoExterno() {
        return codigoExterno;
    }

    /**
     * Sets the value of the codigoExterno property.
     * 
     */
    public void setCodigoExterno(long value) {
        this.codigoExterno = value;
    }

}
