package ru.netology.hibernate.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.hibernate.entities.Person;
import ru.netology.hibernate.repositories.PersonsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonsService {

    private final PersonsRepository personsRepository;

    public List<Person> findByCityOfLiving(String cityOfLiving) {
        return personsRepository.findByCityOfLiving(cityOfLiving)
                .orElseThrow(() -> new RuntimeException("Person with city " + cityOfLiving + " not found"));
    }

    public List<Person> findByAgeLessThan(int age) {
        return personsRepository.findByPkAgeLessThanOrderByPkAgeAsc(age)
                .orElseThrow(() -> new RuntimeException("Person with age " + age + " not found"));
    }

    public Person savePerson(Person person) {
        return personsRepository.save(person);
    }

    public List<Person> findByNameAndSurname(String name, String surname) {
        return personsRepository.findByPkNameAndPkSurname(name, surname)
                .orElseThrow(() -> new RuntimeException("Person with name " + name + " and surname " + surname + " not found"));
    }
}
