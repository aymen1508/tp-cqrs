package com.cqrs.cqrs.controllers;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.*;

import com.cqrs.cqrs.command_event.CreateProductCommand;
import com.cqrs.cqrs.entities.Product;
import org.springframework.web.bind.annotation.GetMapping; 
 
@RestController 
@RequestMapping("/products") 
public class ProductCommandController { 
 
    @Autowired 
    private CommandGateway commandGateway; 
 
    @PostMapping 
    public String createProduct(@RequestBody Product product) { 
        String id = UUID.randomUUID().toString(); 
        CreateProductCommand command = new CreateProductCommand( 
                id, product.getName(), product.getDescription(), product.getPrice(), 
product.getStock()); 
        commandGateway.sendAndWait(command); 
        return id; 
    } 
    
} 