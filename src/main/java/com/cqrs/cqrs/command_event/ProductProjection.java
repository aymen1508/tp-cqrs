package com.cqrs.cqrs.command_event;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.queryhandling.QueryHandler; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Component;

import com.cqrs.cqrs.entities.Product;
import com.cqrs.cqrs.repositories.ProductRepository; 
 
 
@Component 
@ProcessingGroup("productProcessor")
public class ProductProjection { 
 
    @Autowired 
    private ProductRepository productRepository; 
 
    @QueryHandler 
    public Product handle(GetProductByIdQuery query) { 
        return productRepository.findById(query.getId()).orElse(null); 
    }
}
