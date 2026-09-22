package com.tads.ecommerce.service.exception;

import com.tads.ecommerce.service.CategoryService;

public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
