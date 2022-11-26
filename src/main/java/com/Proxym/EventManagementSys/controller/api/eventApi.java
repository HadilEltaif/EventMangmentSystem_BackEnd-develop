package com.Proxym.EventManagementSys.controller.api;

import com.Proxym.EventManagementSys.dto.EventDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.Proxym.EventManagementSys.utils.Constants.APP_ROOT;

public interface eventApi {
    @PostMapping(value = APP_ROOT +"/events/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    EventDto save(@RequestBody EventDto eventDto);


    @GetMapping(value = APP_ROOT+"/event/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    EventDto findByEventId(@PathVariable Long id);

    /*@GetMapping(value = APP_ROOT+"/event/{Keyword}",produces = MediaType.APPLICATION_JSON_VALUE)
    EventDto findByKeyword(@PathVariable String Keyword);*/

    @GetMapping(value = APP_ROOT+"/event/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<EventDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/event/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Long id);
}
