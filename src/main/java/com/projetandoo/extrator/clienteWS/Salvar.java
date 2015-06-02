
package com.projetandoo.extrator.clienteWS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for salvar complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="salvar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="produto" type="{http://schema.varejodigital.projetandoo/1.0/}ProdutoType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "salvar", namespace = "http://service.varejodigital.projetandoo/1.0/", propOrder = {
    "produto"
})
public class Salvar {

    protected ProdutoType produto;

    /**
     * Gets the value of the produto property.
     * 
     * @return
     *     possible object is
     *     {@link ProdutoType }
     *     
     */
    public ProdutoType getProduto() {
        return produto;
    }

    /**
     * Sets the value of the produto property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProdutoType }
     *     
     */
    public void setProduto(ProdutoType value) {
        this.produto = value;
    }

}
