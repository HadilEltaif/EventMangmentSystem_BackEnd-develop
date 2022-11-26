package com.Proxym.EventManagementSys.controller.api;

import com.Proxym.EventManagementSys.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.Proxym.EventManagementSys.utils.Constants.APP_ROOT;

public interface categoryApi {
    @PostMapping(value = APP_ROOT +"/category/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody CategoryDto categoryDto);

    @GetMapping(value = APP_ROOT+"/category/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCategoryId(@PathVariable Long id);

    @GetMapping(value = APP_ROOT+"/category/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/category/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Long id);
}
