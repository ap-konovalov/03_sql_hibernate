package ru.netology.hibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entities.Person;
import ru.netology.hibernate.entities.PersonsPK;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonsRepository extends JpaRepository<Person, PersonsPK> {

    Optional<List<Person>> findByCityOfLiving(String cityOfLiving);

    Optional<List<Person>> findByPkAgeLessThanOrderByPkAgeAsc(int age);

    Optional<List<Person>> findByPkNameAndPkSurname(String name, String surname);
}
