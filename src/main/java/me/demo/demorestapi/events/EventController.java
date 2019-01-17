package me.demo.demorestapi.events;

import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Controller
@RequestMapping(value = "/api/events", produces = MediaTypes.HAL_JSON_UTF8_VALUE)
public class EventController {

    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @PostMapping
//    @PostMapping("/api/events")
    public ResponseEntity createEvent(@RequestBody Event event) {

        Event newEvent = this.eventRepository.save(event);
        URI uri = linkTo(EventController.class).slash(newEvent.getId()).toUri();

////        URI uri = linkTo(methodOn(EventController.class).createEvent(null)).slash("{id}").toUri();
//        URI uri = linkTo(EventController.class).slash("{id}").toUri();
//        event.setId(10);
////        return ResponseEntity.created(uri).build();
        return ResponseEntity.created(uri).body(event);

    }

}
