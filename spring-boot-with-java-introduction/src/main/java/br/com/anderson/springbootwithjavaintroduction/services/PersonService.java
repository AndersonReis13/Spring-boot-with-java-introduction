package br.com.anderson.springbootwithjavaintroduction.services;

import br.com.anderson.springbootwithjavaintroduction.controllers.PersonController;
import br.com.anderson.springbootwithjavaintroduction.data.vo.v1.PersonVo;
import br.com.anderson.springbootwithjavaintroduction.entites.Person;
import br.com.anderson.springbootwithjavaintroduction.exceptions.ResourceNotFoundExceptions;
import br.com.anderson.springbootwithjavaintroduction.repositories.PersonRepository;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService{

    @Autowired
    private PersonRepository repository;
    private Logger logger = Logger.getLogger(PersonController.class.getName());

    public List<PersonVo> findAll(){

        logger.info("Finding all people!");

        return repository.findAll();
    }

    public PersonVo findById(Long id){
        logger.info("Finding one person");


        return repository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundExceptions("Not found person ID!"));
    }

    public PersonVo create(PersonVo person){
        logger.info("Creating person");

        return repository.save(person);
    }

    public PersonVo update(PersonVo person){
      logger.info("Updating person");

        var entity = repository.findById(person.getId())
                .orElseThrow(()-> new ResourceNotFoundExceptions("Not found person ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());

      return person;
    }

    public void delete(Long id){
        logger.info("Deleting one person");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("Not found person ID!"));
        repository.delete(entity);
    }
}
