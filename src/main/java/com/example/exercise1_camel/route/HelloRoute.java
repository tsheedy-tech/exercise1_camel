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
//                .process(new Processor() {
//                    @Override
//                    public void process(Exchange exchange) throws Exception {
//                        Person person = exchange.getIn().getBody(Person.class);
//                        Response response = new Response(person.getName());
//                        exchange.getIn().setBody(response);
//                    }
//                });
        .setBody(exchange -> {
            Person person = exchange.getIn().getBody(Person.class);
            return new Response(person.getName());
        });
    }
}
