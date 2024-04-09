package br.com.anderson.springbootwithjavaintroduction.repositories;

import br.com.anderson.springbootwithjavaintroduction.data.vo.v1.PersonVo;
import br.com.anderson.springbootwithjavaintroduction.entites.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonVo, Long> {}
