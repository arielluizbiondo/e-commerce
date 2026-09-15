package com.tads.ecommerce.dto;

import com.tads.ecommerce.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CategoryDTO
{
    private long id;
    private String name;

    public CategoryDTO(Category entity)
    {
        id = entity.getId();
        name = entity.getNome();
    }
}
