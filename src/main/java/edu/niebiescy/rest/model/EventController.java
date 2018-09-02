package edu.niebiescy.rest.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class EventController {

    private final EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addEvent(@RequestBody Event event) {

        eventRepository.save(event);

    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Event> getEvents() {

        return eventRepository.findAll();

    }


}
