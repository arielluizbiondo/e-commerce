package com.tads.ecommerce.service;

import com.tads.ecommerce.dto.CategoryDTO;
import com.tads.ecommerce.entity.Category;
import com.tads.ecommerce.repository.CategoryRepository;
import com.tads.ecommerce.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
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
    @Transactional
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
        Category entity = obj.orElseThrow(()->new ResourceNotFoundException("Entity not found."));

        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO dto)
    {
        Category entity = new Category();
        entity.setNome(dto.getName());

        entity = repository.save(entity);
        return new CategoryDTO(entity);
    }

    public CategoryDTO update(Long id, CategoryDTO dto)
    {
        try
        {
            Category entity = repository.getReferenceById(id);
            entity.setNome(dto.getName());
            entity = repository.save(entity);
            return new CategoryDTO(entity);

        }
        catch(EntityNotFoundException ex)
        {
            throw new ResourceNotFoundException("Entity not found." + id);
        }
    }
}
