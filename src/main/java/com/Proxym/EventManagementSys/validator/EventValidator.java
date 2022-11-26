package com.Proxym.EventManagementSys.validator;

import com.Proxym.EventManagementSys.dto.EventDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EventValidator {
    public static List<String> validate(EventDto eventDto){
        List<String> errors = new ArrayList<>();


        //case the eventDto is null
        if(eventDto == null){
            errors.add("Veuillez saisir  un titre pour l'evenement!!! ");
            errors.add("Veuillez saisir  une description  pour l'evenement!!! ");
            errors.add("Veuillez insérer au moins une photo pour l'evenement!!! ");
            errors.add("Veuillez saisir  le prix de l'evenement!!! ");
            errors.add("Veuillez saisir la catégorie de l'evenement!!! ");
        }
        else {
            if (!StringUtils.hasLength(eventDto.getTitleEvent()))
                errors.add("Veuillez saisir  un titre pour l'evenement!!! ");

            if (!StringUtils.hasLength(eventDto.getDescription()))
                errors.add("Veuillez saisir  une description  pour l'evenement!!! ");

            if (!StringUtils.hasLength(eventDto.getPhoto()))
                errors.add("Veuillez insérer au moins une photo pour l'evenement!!! ");

            if ((eventDto.getTicketPrice() == null))
                errors.add("Veuillez saisir  le prix de l'evenement!!! ");

            if (eventDto.getCategory() == null)
                errors.add("Veuillez sélectionner la catégorie de l'evenement!!! ");
        }

        return errors;}
}
