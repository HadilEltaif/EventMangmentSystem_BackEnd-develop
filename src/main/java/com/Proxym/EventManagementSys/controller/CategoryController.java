package com.Proxym.EventManagementSys.controller;

import com.Proxym.EventManagementSys.controller.api.categoryApi;
import com.Proxym.EventManagementSys.dto.CategoryDto;
import com.Proxym.EventManagementSys.service.categoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController implements categoryApi {

    private final categoryService categoryService;
    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @Override
    public CategoryDto findByCategoryId(Long id) {
        return categoryService.findByCategoryId(id);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void delete(Long id) {
        categoryService.delete(id);
    }
}
