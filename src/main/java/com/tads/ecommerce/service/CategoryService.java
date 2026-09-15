package com.tads.ecommerce.service;

import com.tads.ecommerce.dto.CategoryDTO;
import com.tads.ecommerce.entity.Category;
import com.tads.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class CategoryService
{
    @Autowired
    private CategoryRepository repository;
    public List<CategoryDTO> findAll()
    {
        List<Category> list = repository.findAll();

        List<CategoryDTO> ListDTO = list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());

        return ListDTO;
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id)
    {
        Optional<Category> obj = repository.findById(id);
        Category entity = obj.get();

        return new CategoryDTO(entity);
    }
}
