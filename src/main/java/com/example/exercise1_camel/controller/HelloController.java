package com.example.exercise1_camel.controller;

import com.example.exercise1_camel.model.Person;
import com.example.exercise1_camel.model.Response;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    private final ProducerTemplate producerTemplate;

    public HelloController(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    @PostMapping(path = "/api/hello")
    public Response hello(@RequestBody Person person) {
        return producerTemplate.requestBody("direct:hello", person, Response.class);
    }
}
