package com.tads.ecommerce.resource;

import com.tads.ecommerce.entity.Category;
import com.tads.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/categories")

public class CategoryResource
{
    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity <List<Category>> findAll()
    {
        List<Category> list = service.findAll();
        return ResponseEntity.ok(list);
    }
}
