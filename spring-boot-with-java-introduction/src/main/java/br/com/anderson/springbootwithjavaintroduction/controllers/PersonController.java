package br.com.anderson.springbootwithjavaintroduction.controllers;

import br.com.anderson.springbootwithjavaintroduction.entites.Person;
import br.com.anderson.springbootwithjavaintroduction.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "{id}")
    public Person findById(@PathVariable(value = "id") String id) throws Exception{
            return personService.findById(Long.valueOf(id));
    }

    @GetMapping
    public List<Person> findAll(){
        return personService.findAll();
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        return personService.create(person);
    }

    @PutMapping
    public Person update(@RequestBody Person person){
        return personService.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
            personService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
