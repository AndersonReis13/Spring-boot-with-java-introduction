package br.com.anderson.springbootwithjavaintroduction.controllers;

import br.com.anderson.springbootwithjavaintroduction.entites.Person;
import br.com.anderson.springbootwithjavaintroduction.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") String id) throws Exception{
            return personService.findById(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findById(){
        return personService.findAll();
    }

}