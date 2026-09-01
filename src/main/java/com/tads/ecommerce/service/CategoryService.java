package com.tads.ecommerce.service;

import com.tads.ecommerce.entity.Category;
import com.tads.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryService
{
    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll()
    {
        List<Category> list = repository.findAll();
        return list;
    };
}