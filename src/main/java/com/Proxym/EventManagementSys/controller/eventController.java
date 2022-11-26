package com.Proxym.EventManagementSys.controller;

import com.Proxym.EventManagementSys.controller.api.eventApi;
import com.Proxym.EventManagementSys.dto.EventDto;
import com.Proxym.EventManagementSys.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class eventController implements eventApi {
    private  EventService eventService;

    @Override
    public EventDto save(EventDto eventDto) {
        return eventService.save(eventDto);
    }

    @Override
    public EventDto findByEventId(Long id) {
        return eventService.findByEventId(id);
    }

    @Override
    public List<EventDto> findAll() {
        return eventService.findAll();
    }

    @Override
    public void delete(Long id) {
        eventService.delete(id);
    }
}
