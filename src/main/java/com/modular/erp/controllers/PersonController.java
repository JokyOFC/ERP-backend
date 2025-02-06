package com.modular.erp.controllers;

import com.modular.erp.entities.Person;
import com.modular.erp.repositories.PersonRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/persons")
    public Iterable<Person> findAllPersons(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                           @RequestParam(name = "size", required = false, defaultValue = "10") int size,
                                           @RequestParam(name = "sort", required = false, defaultValue = "name") String sort,
                                           @RequestParam(name = "order", required = false, defaultValue = "asc") String order){
        return switch (order) {
            case "desc" -> this.personRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, sort)));
            case "asc" -> this.personRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sort)));
            default -> this.personRepository.findAll(PageRequest.of(page, size, Sort.by(sort)));
        };

    }

    @PostMapping("/persons")
    public Person savePerson(@RequestBody Person person){
        return this.personRepository.save(person);
    }

}
