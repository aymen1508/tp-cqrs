package com.cqrs.cqrs.command_event;

import lombok.Getter;

@Getter
public class GetProductByIdQuery { 
    private final String id; 
 
    public GetProductByIdQuery(String id) { 
        this.id = id; 
    } 
 
    // Getter 
} 