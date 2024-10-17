package dev.fedichkin.hibernate.Repository;


import dev.fedichkin.hibernate.Entity.Persons;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonsRepository {

    @PersistenceContext
    public EntityManager entityManager;

    @Transactional
    public Persons getPersonByCity(String city) throws SQLException {
        setTestData();

        List<Persons> personsList = new ArrayList<>();

        personsList.add(entityManager.find(Persons.class, 1L));
        personsList.add(entityManager.find(Persons.class, 2L));
        personsList.add(entityManager.find(Persons.class, 3L));

        for(Persons person : personsList) {
            if(person.getCity_of_living().equals(city)) {
                return person;
            }
        }

        return new Persons();
    }

    @Transactional
    public void setTestData() {
        Persons person1 = Persons.builder()
                .age(40)
                .name("name1")
                .surname("surname1")
                .phone_number("111")
                .city_of_living("Moskow")
                .build();
        entityManager.persist(person1);

        Persons person2 = Persons.builder()
                .age(41)
                .name("name2")
                .surname("surname2")
                .phone_number("222")
                .city_of_living("SPB")
                .build();
        entityManager.persist(person2);

        Persons person3 = Persons.builder()
                .age(43)
                .name("name3")
                .surname("surname3")
                .phone_number("333")
                .city_of_living("Kazan")
                .build();
        entityManager.persist(person3);
    }

}
