package com.example.reactiveapi.controller;


import com.example.reactiveapi.model.Foo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@RestController
public class FooController {


    @GetMapping(value="/foo",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Foo> getFoo() {

        return Flux.interval(Duration.ofSeconds(1))
                .log()
                .map(val -> new Foo(val,"Foo user"));
    }


}
