package com.Proxym.EventManagementSys.service;

import com.Proxym.EventManagementSys.dto.CategoryDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface categoryService {
    CategoryDto save(CategoryDto categoryDto);

    CategoryDto findByCategoryId(Long id);

    List<CategoryDto> findAll();

    void delete(Long id);
}
