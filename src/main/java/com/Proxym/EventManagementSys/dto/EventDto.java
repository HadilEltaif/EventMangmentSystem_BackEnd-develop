package com.Proxym.EventManagementSys.dto;

import com.Proxym.EventManagementSys.model.Event;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDto {
    private Long EventId;
    private String TitleEvent;
    private String Description;
    private Instant DepositDate;
    private Float TicketPrice;
    private Integer NumberViews;
    private Integer voteCount;
    private String photo;
    private CategoryDto category;
    @JsonIgnore
    private userDto user;

    public static EventDto fromEntity(Event event){
        if (event == null)
            return  null;
         //TODO throw new exception
        //event -> eventDto
        return EventDto.builder().EventId(event.getEventId())
                .TitleEvent(event.getTitleEvent())
                .Description(event.getDescription())
                .DepositDate(event.getDepositDate())
                .TicketPrice(event.getTicketPrice())
                .NumberViews(event.getNumberViews())
                .voteCount(event.getVoteCount())
                .photo(event.getPhoto())
                .category(CategoryDto.fromEntity(event.getCategory()))
                //.user(userDto.fromEntity(event.getUser()))
                 .build();
    }


    public static Event toEntity(EventDto eventDto){
        if (eventDto == null)
            return  null;
           //TODO Throw new exception
        //eventDto -> event
        Event event = new Event();
        event.setEventId(eventDto.getEventId());
        event.setTitleEvent(eventDto.getTitleEvent());
        event.setDescription(eventDto.getDescription());
        event.setDepositDate(eventDto.getDepositDate());
        event.setTicketPrice(eventDto.getTicketPrice());
        event.setNumberViews(eventDto.getNumberViews());
        event.setVoteCount(event.getVoteCount());
        event.setPhoto(eventDto.getPhoto());
        event.setCategory(CategoryDto.toEntity(eventDto.getCategory()));
        event.setUser(userDto.toEntity(eventDto.getUser()));
        return  event;

    }

}
