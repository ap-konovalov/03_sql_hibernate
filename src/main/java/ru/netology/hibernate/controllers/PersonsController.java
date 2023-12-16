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
    public ResponseEntity<List<Person>> getPersonsByCity(@RequestParam String city) {
        return ResponseEntity.ok(personsService.findByCityOfLiving(city));
    }

    @GetMapping("/persons/by-age")
    public ResponseEntity<List<Person>> getByAgeLessThan(@RequestParam int age) {
        return ResponseEntity.ok(personsService.findByAgeLessThan(age));
    }

    @GetMapping("/persons/by-name-surname")
    public ResponseEntity<List<Person>> getByNameAndSurname(@RequestParam String name,
                                                            @RequestParam String surname) {
        return ResponseEntity.ok(personsService.findByNameAndSurname(name, surname));
    }

    @PostMapping("/person")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        return ResponseEntity.ok(personsService.savePerson(person));
    }
}
