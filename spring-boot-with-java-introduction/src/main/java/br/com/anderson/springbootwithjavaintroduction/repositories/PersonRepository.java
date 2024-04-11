package br.com.anderson.springbootwithjavaintroduction.repositories;

import br.com.anderson.springbootwithjavaintroduction.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
