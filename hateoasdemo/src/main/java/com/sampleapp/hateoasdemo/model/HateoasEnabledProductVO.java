package com.sampleapp.hateoasdemo.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;

@XmlRootElement(name = "hateoasEnabledProduct")
@XmlAccessorType(XmlAccessType.NONE)
public class HateoasEnabledProductVO extends ResourceSupport implements Serializable
{
    private static final long serialVersionUID = 1L;
     
    public HateoasEnabledProductVO(Integer productId, String productName, String description, String stockStatus) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.stockStatus = stockStatus;
    }
 
    public HateoasEnabledProductVO() {
 
    }
 
    @XmlAttribute
    private Integer productId;
 
    @XmlElement
    private String productName;
 
    @XmlElement
    private String description;
    
    @XmlElement
    private String stockStatus;
 
 
    public String getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}

	@Override
    public String toString() {
        return "ProductVO [id=" + productId + ", name=" + productName + ", description=" + description +"]";
    }

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}