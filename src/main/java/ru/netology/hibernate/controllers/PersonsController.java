package ru.netology.hibernate.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.hibernate.entities.Person;
import ru.netology.hibernate.services.PersonsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonsController {

    private final PersonsService personsService;

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personsService.getPersonsByCity(city);
    }

    @PostMapping("/person")
    public ResponseEntity addPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personsService.addPerson(person));
    }
}
