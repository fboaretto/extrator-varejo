
package com.projetandoo.extrator.clienteWS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ProdutoResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProdutoResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServiceStatus" type="{http://schema.varejodigital.projetandoo/1.0/}StatusType" minOccurs="0"/>
 *         &lt;element name="dataProcessamento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="produto" type="{http://schema.varejodigital.projetandoo/1.0/}ProdutoType" minOccurs="0"/>
 *         &lt;element name="motivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProdutoResponseType", propOrder = {
    "serviceStatus",
    "dataProcessamento",
    "produto",
    "motivo"
})
public class ProdutoResponseType {

    @XmlElement(name = "ServiceStatus")
    protected StatusType serviceStatus;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataProcessamento;
    protected ProdutoType produto;
    protected String motivo;

    /**
     * Gets the value of the serviceStatus property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getServiceStatus() {
        return serviceStatus;
    }

    /**
     * Sets the value of the serviceStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setServiceStatus(StatusType value) {
        this.serviceStatus = value;
    }

    /**
     * Gets the value of the dataProcessamento property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataProcessamento() {
        return dataProcessamento;
    }

    /**
     * Sets the value of the dataProcessamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataProcessamento(XMLGregorianCalendar value) {
        this.dataProcessamento = value;
    }

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

    /**
     * Gets the value of the motivo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Sets the value of the motivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivo(String value) {
        this.motivo = value;
    }

}
