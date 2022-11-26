package com.Proxym.EventManagementSys.service.Impl;

import com.Proxym.EventManagementSys.exception.entityNotFoundException;
import com.Proxym.EventManagementSys.exception.errorCodes;
import com.Proxym.EventManagementSys.exception.invalidEntityException;
import com.Proxym.EventManagementSys.dto.EventDto;
import com.Proxym.EventManagementSys.model.Event;
import com.Proxym.EventManagementSys.repository.EventRepository;
import com.Proxym.EventManagementSys.service.EventService;
import com.Proxym.EventManagementSys.validator.EventValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Data
@AllArgsConstructor
@Service
public class EventServiceImp implements EventService {

    private final EventRepository eventRepository;

   /* @Autowired
    public EventServiceImp(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }*/

    @Override
    public EventDto save(EventDto eventDto) {
        List<String> errors = EventValidator.validate(eventDto);
        if (!errors.isEmpty()) {
            log.error("Event est invalid !{}", eventDto);
            throw new invalidEntityException("Event est invalid !", errorCodes.EVENT_NOT_VALID, errors);
        }
        return eventDto.fromEntity(eventRepository.save(eventDto.toEntity(eventDto)));
    }

    @Override
    public EventDto findByEventId(Long id) {
        if (id == null) {
            log.error("the event id is null{}");
            return null;
        }
        Optional<Event> event = eventRepository.findById(id);
        EventDto dto = EventDto.fromEntity(event.get());
        return Optional.of(dto).orElseThrow(()
                -> new entityNotFoundException("No event with this ID : "
                + id + "was not found in the DB  ", errorCodes.EVENT_NOT_FOUND));
    }

   /* @Override
    public EventDto findByKeyword(String Keyword) {

        if (!StringUtils.hasLength(Keyword)) {
            log.error("le mot clé est null{}");
            return null;
        }
        Optional<Event> event = eventRepository.findByKeyword(Keyword);
        EventDto dto = EventDto.fromEntity(event.get());
        return Optional.of(dto).orElseThrow(()
                -> new EntityNotFoundException("Aucun Event avec ce mot clé : "
                + Keyword + "n'a été trouvé dans la BDD ", ErrorCodes.EVENT_NOT_FOUND));
    }*/

    @Override
    public List<EventDto> findAll() {
        return eventRepository.findAll().stream()
                .map(EventDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("the event id is null{}");
        }
        eventRepository.deleteById(id);

    }
}
