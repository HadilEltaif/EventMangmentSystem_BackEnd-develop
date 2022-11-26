package com.Proxym.EventManagementSys.controller.api;

import com.Proxym.EventManagementSys.dto.CategoryDto;
import com.Proxym.EventManagementSys.dto.commentDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.Proxym.EventManagementSys.utils.Constants.APP_ROOT;

public interface commentApi {
    @PostMapping(value = APP_ROOT +"/comment/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    commentDto save(@RequestBody commentDto commentDto);

    @GetMapping(value = APP_ROOT+"/comment/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    commentDto findByCategoryId(@PathVariable Long id);

    @GetMapping(value = APP_ROOT+"/comment/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<commentDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/comment/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Long id);
}
