package ru.netology.hibernate.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entities.Person;
import ru.netology.hibernate.entities.PersonsPK;

import java.util.List;

@Repository
@NoArgsConstructor
public class PersonsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        var query = entityManager.createQuery("SELECT p FROM Person p WHERE p.cityOfLiving = ?1", Person.class);
        return query.setParameter(1, city).getResultList();
    }

    @Transactional
    public HttpStatus addPerson(Person person) {
        PersonsPK pk = PersonsPK.builder()
                .age(person.getPk().getAge())
                .name(person.getPk().getName())
                .surname(person.getPk().getSurname())
                .build();
        if (entityManager.find(Person.class, pk) == null) {
            entityManager.persist(person);
            return HttpStatus.CREATED;
        }
        return HttpStatus.BAD_REQUEST;
    }
}
