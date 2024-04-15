package br.com.anderson.springbootwithjavaintroduction.controllers;

import br.com.anderson.springbootwithjavaintroduction.data.vo.v1.PersonVo;
import br.com.anderson.springbootwithjavaintroduction.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/person/v1")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "{id}")
    public PersonVo findById(@PathVariable(value = "id") String id) throws Exception{
            return personService.findById(Long.valueOf(id));
    }

    @GetMapping
    public List<PersonVo> findAll(){
        return personService.findAll();
    }

    @PostMapping
    public PersonVo create(@RequestBody PersonVo person){
        return personService.create(person);
    }

    @PutMapping
    public PersonVo update(@RequestBody PersonVo person){
        return personService.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
            personService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
