package org.example.securityproject.services;

//import jakarta.transaction.Transactional;

import org.example.securityproject.entity.Person;
import org.example.securityproject.entity.PersonId;
import org.example.securityproject.reporitory.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersonsByCity(String city){
        return personRepository.findBycityOfLiving(city);
    }

    public List<Person> findByAgeLessThanOrderByAgeAsc(int age){
        return personRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    public Optional<Person> findByNameAndSurname(String name, String surname){
        return personRepository.findByNameAndSurname(name, surname);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public ResponseEntity<Person> updatePerson(String name, String surname, int age, Person updatedPerson) {
        // Создаем объект PersonId для поиска пользователя по составному ключу
        PersonId id = new PersonId();
        id.setName(name);
        id.setSurname(surname);
        id.setAge(age);

        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person existingPerson = optionalPerson.get();
            existingPerson.setPhoneNumber(updatedPerson.getPhoneNumber());
            existingPerson.setCityOfLiving(updatedPerson.getCityOfLiving());
            personRepository.save(existingPerson); // Сохраняем обновленного пользователя
            return ResponseEntity.ok(existingPerson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteById(String name, String surname, int age) {
        // Создаем объект PersonId для поиска пользователя по составному ключу
        PersonId id = new PersonId();
        id.setName(name);
        id.setSurname(surname);
        id.setAge(age);

        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            personRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}