package com.Proxym.EventManagementSys.service.Impl;

import com.Proxym.EventManagementSys.dto.CategoryDto;
import com.Proxym.EventManagementSys.dto.EventDto;
import com.Proxym.EventManagementSys.exception.entityNotFoundException;
import com.Proxym.EventManagementSys.exception.errorCodes;
import com.Proxym.EventManagementSys.exception.invalidEntityException;
import com.Proxym.EventManagementSys.model.Category;
import com.Proxym.EventManagementSys.repository.categoryRepository;
import com.Proxym.EventManagementSys.service.categoryService;
import com.Proxym.EventManagementSys.validator.CategoryValidator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Data
@Service
public class categoryServiceImp implements categoryService {

    private final categoryRepository categoryRepository;

    @Override
    public CategoryDto save(CategoryDto Dto) {
        List<String> errors = CategoryValidator.validate(Dto);
        if (!errors.isEmpty()) {
            log.error("Category is invalid !{}", Dto);
            throw new invalidEntityException("Category is invalid !",
                    errorCodes.CATEGORY_NOT_VALID, errors);
        }
        CategoryDto dto;
        dto = Dto.fromEntity(categoryRepository.save(Dto.toEntity(Dto)));
        return dto;
    }

    @Override
    public CategoryDto findByCategoryId(Long id) {
        if (id == null) {
            log.error("the category id is null{}");
            return null;
        }
        Optional<Category> category = categoryRepository.findById(id);
        CategoryDto dto = CategoryDto.fromEntity(category.get());
        return Optional.of(dto).orElseThrow(()
                -> new entityNotFoundException("No Category with ID : "
                + id + "was not found in the DB ", errorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("the category id is null{}");
        }
        categoryRepository.deleteById(id);

    }
    }

