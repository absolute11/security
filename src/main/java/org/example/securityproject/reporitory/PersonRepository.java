package org.example.securityproject.reporitory;

import org.example.securityproject.entity.Person;
import org.example.securityproject.entity.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {
    List<Person> findBycityOfLiving(String city);
    List<Person> findByAgeLessThanOrderByAgeAsc(int age);
    Optional<Person> findByNameAndSurname(String name, String surname);
}