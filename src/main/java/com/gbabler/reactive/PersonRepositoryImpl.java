package com.gbabler.reactive;

import com.gbabler.reactive.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

public class PersonRepositoryImpl implements PersonRepository {

    Person michael = new Person(1, "Michael", "Weston");
    Person fiona = new Person(2, "Fiona", "Glenanne");
    Person sam = new Person(3, "Sam", "Axe");
    Person jesse = new Person(4, "Jesse", "Porter");

    @Override
    public Mono<Person> getById(final Integer id) {
        return findAll()
                .filter(person -> Objects.equals(person.getId(), id))
                .next();
    }

    @Override
    public Flux<Person> findAll() {
        return Flux.just(michael, fiona, sam, jesse);
    }
}