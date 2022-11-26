package com.Proxym.EventManagementSys.dto;

import com.Proxym.EventManagementSys.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Builder
public class CategoryDto {
    private Long id;
    private String code;
    private String designation;
    @JsonIgnore
    private List<EventDto> events;

    public static CategoryDto fromEntity(Category category) {
        if (category == null) {
            //TODO throw an Exception
            return null;
        }
        //Category -> CategoryDto
        return CategoryDto.builder().id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation()).build();

    }

    public static Category toEntity(CategoryDto categoryDto) {
        if (categoryDto == null)
            //TODO throw an Exception
            return null;
        //categoryDTO -> category
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());
        return category;
    }
}
