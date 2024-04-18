package br.com.anderson.springbootwithjavaintroduction.services;

import br.com.anderson.springbootwithjavaintroduction.controllers.PersonController;
import br.com.anderson.springbootwithjavaintroduction.data.vo.v1.PersonVo;
import br.com.anderson.springbootwithjavaintroduction.exceptions.ResourceNotFoundExceptions;
import br.com.anderson.springbootwithjavaintroduction.mapper.DozerMapper;
import br.com.anderson.springbootwithjavaintroduction.model.Person;
import br.com.anderson.springbootwithjavaintroduction.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService{

    @Autowired
    private PersonRepository repository;
    private Logger logger = Logger.getLogger(PersonController.class.getName());

    public List<PersonVo> findAll(){

        logger.info("Finding all people!");

        return DozerMapper.parseListObject(repository.findAll(), PersonVo.class);
    }

    public PersonVo findById(Long id){
        logger.info("Finding one person");


         var entity = repository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundExceptions("Not found person ID!"));

         return DozerMapper.parseObject(entity, PersonVo.class);
    }

    public PersonVo create(PersonVo person){
        logger.info("Creating person");

        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVo.class);
        return vo;
    }

    public PersonVo update(PersonVo person){
      logger.info("Updating person");

        var entity = repository.findById(person.getKey())
                .orElseThrow(()-> new ResourceNotFoundExceptions("Not found person ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVo.class);
        return vo;
    }

    public void delete(Long id){
        logger.info("Deleting one person");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("Not found person ID!"));
        repository.delete(entity);
    }
}
