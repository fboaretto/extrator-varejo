
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
 * <complexType name="salvar">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="produto" type="{http://schema.varejodigital.projetandoo/1.0/}ProdutoCadastroType" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * </pre>
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "salvarProd", 
		 namespace = "http://service.varejodigital.projetandoo/1.0/", 
		 propOrder = { "produto" })
public class Salvar 
{
    protected ProdutoCadastroType produto;

    /**
     * Gets the value of the produto property.
     * 
     * @return
     *     possible object is
     *     {@link ProdutoCadastroType }
     *     
     */
    public ProdutoCadastroType getProduto() {
        return produto;
    }

    /**
     * Sets the value of the produto property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProdutoCadastroType }
     *     
     */
    public void setProduto(ProdutoCadastroType value) {
        this.produto = value;
    }

}
