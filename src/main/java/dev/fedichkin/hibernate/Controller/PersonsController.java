package dev.fedichkin.hibernate.Controller;

import dev.fedichkin.hibernate.Repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class PersonsController {

    @Autowired
    public PersonsRepository personsRepository;

    @GetMapping("/persons/by-city/{city}")
    public String fetchPerson(@PathVariable String city) throws SQLException {
        return personsRepository.getPersonByCity(city).toString();
    }
}
