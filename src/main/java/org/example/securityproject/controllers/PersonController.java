package org.example.securityproject.controllers;


import org.example.securityproject.entity.Person;
import org.example.securityproject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {

        return personService.getPersonsByCity(city);
    }

    @GetMapping("/by-age")
    public List<Person> getPersonsByAge(@RequestParam int age) {
        return personService.findByAgeLessThanOrderByAgeAsc(age);
    }

    @GetMapping("/by-name-surname")
    public Optional<Person> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personService.findByNameAndSurname(name, surname);
    }

    @PostMapping("/create")
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }
    @PutMapping("/update/{name}/{surname}/{age}")
    public ResponseEntity<Person> updatePerson(
            @PathVariable String name,
            @PathVariable String surname,
            @PathVariable int age,
            @RequestBody Person updatedPerson) {
        return personService.updatePerson(name, surname, age, updatedPerson);
    }
    @DeleteMapping("/delete/{name}/{surname}/{age}")
    public ResponseEntity<Void> deletePerson(
            @PathVariable String name,
            @PathVariable String surname,
            @PathVariable int age) {
        return personService.deleteById(name, surname, age);
    }

}