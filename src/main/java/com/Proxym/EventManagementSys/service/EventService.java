package com.Proxym.EventManagementSys.service;

import com.Proxym.EventManagementSys.dto.EventDto;

import java.util.List;


public interface EventService {

    EventDto save(EventDto eventDto);//Enregistrer un ou modifier un event

    EventDto findByEventId(Long id);

    //EventDto findByKeyword(String Keyword);

    List<EventDto> findAll();

    void delete(Long id);
    //TODO Ajouter des métthodes au fur et à mésure



    }

