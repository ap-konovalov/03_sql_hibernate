package ru.netology.hibernate.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.netology.hibernate.entities.Person;
import ru.netology.hibernate.repositories.PersonsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonsService {

    private final PersonsRepository personsRepository;

    public List<Person> getPersonsByCity(String name) {
        return personsRepository.getPersonsByCity(name);
    }

    public HttpStatus addPerson(Person person) {
        return personsRepository.addPerson(person);
    }
}
