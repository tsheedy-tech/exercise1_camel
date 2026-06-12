package com.example.exercise1_camel.route;

import com.example.exercise1_camel.model.Person;
import com.example.exercise1_camel.model.Response;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class HelloRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("direct:hello")
                .setBody(exchange -> {
                    Person person = (Person) exchange.getIn().getBody();
                    return new Response(person.getName());
                });
    }
}