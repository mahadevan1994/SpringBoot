package com.sampleapp.hateoasdemo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.hateoas.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="hateoasEnabledProducts")
public class HateoasEnabledProductListVO extends ResourceSupport implements Serializable
{
    private static final long serialVersionUID = 1L;
      
    private List<HateoasEnabledProductVO> hateoasEnabledProducts = new ArrayList<HateoasEnabledProductVO>();
    
    public List<HateoasEnabledProductVO> getHateoasEnabledProducts() {
        return hateoasEnabledProducts;
    }
  
    public void setProducts(List<HateoasEnabledProductVO> hateoasEnabledProducts) {
        this.hateoasEnabledProducts = hateoasEnabledProducts;
    }
}