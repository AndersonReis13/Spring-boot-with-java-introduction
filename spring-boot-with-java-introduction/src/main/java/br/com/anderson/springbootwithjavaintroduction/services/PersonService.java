package br.com.anderson.springbootwithjavaintroduction.services;

import br.com.anderson.springbootwithjavaintroduction.controllers.PersonController;
import br.com.anderson.springbootwithjavaintroduction.entites.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService{

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonController.class.getName());

    public List<Person> findAll(){

        logger.info("Finding all people!");

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(Long id){
        logger.info("Finding one person");

        Person person = new Person();
        person.setId(counter.getAndIncrement());
        person.setFirstName("Anderson");
        person.setLastName("Silva");
        person.setAddress("Salvador - Bahia - Brasil");
        person.setGender("Male");
        return person;
    }


    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Some address in Brasil " + i);
        person.setGender("Male");
        return person;
    }

}
