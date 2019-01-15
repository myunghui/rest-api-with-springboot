package me.demo.demorestapi.events;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class EventTest {

    @Test
    public void builder() {
        Event event = Event.builder().name("Spring REST API").description("REST API development with Spring Boot").build();
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean() {

        String name = "Event";
        String desc = "Spring";
        Event event = new Event();
        event.setName(name);
        event.setDescription(desc);
        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(desc);

    }

}