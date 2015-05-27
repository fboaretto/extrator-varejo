
package com.projetandoo.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EstoqueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EstoqueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="minimo" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="disponivel" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="maximo" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ressuprimento" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="reposicao" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EstoqueType", propOrder = {
    "minimo",
    "disponivel",
    "maximo",
    "ressuprimento",
    "reposicao"
})
public class EstoqueType {

    protected long minimo;
    
    protected long disponivel;
    
    protected long maximo;
    
    protected long ressuprimento;
    
    protected long reposicao;

    /**
     * Gets the value of the minimo property.
     * 
     */
    public long getMinimo() {
        return minimo;
    }

    /**
     * Sets the value of the minimo property.
     * 
     */
    public void setMinimo(long value) {
        this.minimo = value;
    }

    /**
     * Gets the value of the disponivel property.
     * 
     */
    public long getDisponivel() {
        return disponivel;
    }

    /**
     * Sets the value of the disponivel property.
     * 
     */
    public void setDisponivel(long value) {
        this.disponivel = value;
    }

    /**
     * Gets the value of the maximo property.
     * 
     */
    public long getMaximo() {
        return maximo;
    }

    /**
     * Sets the value of the maximo property.
     * 
     */
    public void setMaximo(long value) {
        this.maximo = value;
    }

    /**
     * Gets the value of the ressuprimento property.
     * 
     */
    public long getRessuprimento() {
        return ressuprimento;
    }

    /**
     * Sets the value of the ressuprimento property.
     * 
     */
    public void setRessuprimento(long value) {
        this.ressuprimento = value;
    }

    /**
     * Gets the value of the reposicao property.
     * 
     */
    public long getReposicao() {
        return reposicao;
    }

    /**
     * Sets the value of the reposicao property.
     * 
     */
    public void setReposicao(long value) {
        this.reposicao = value;
    }

}
