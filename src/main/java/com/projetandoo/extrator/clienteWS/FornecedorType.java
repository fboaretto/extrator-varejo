
package com.projetandoo.extrator.clienteWS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FornecedorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FornecedorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loja" type="{http://schema.varejodigital.projetandoo/1.0/}LojaType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FornecedorType", propOrder = {
    "nome",
    "loja"
})
public class FornecedorType {

    protected String nome;
    protected LojaType loja;

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

}
