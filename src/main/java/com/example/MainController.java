package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Sebastian on 2015-11-07.
 */
@RestController
public class MainController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/")
    public String welcome(){
        return "Hello";
    }

    @RequestMapping("/saveOne")
    public Person saveOnePerson() {
        Person person = new Person();
        person.setBirthDay(LocalDate.now());
        person.setEmail("test@emial.com");
        person.setFirstName("First Name");
        person.setId(1l);
        person.setLastActivity(new Date());
        person.setLastName("Last name");
        person.setNick("nick");
        person.setPassword("pwd");
        personService.saveUser(person);
        return  person;
    }
}
