package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Sebastian on 2015-11-07.
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public Person saveUser(Person user) {
        final String methodName = "SaveUser";
        long start = System.currentTimeMillis();
        user = personRepository.save(user);
        long end = System.currentTimeMillis() - start;
        System.out.println(methodName+" time: "+end);
        System.out.println(user);
        return user;
    }

    public boolean removeUser(Person user) {
        final String methodName = "removeUser";
        long start = System.currentTimeMillis();
        try {
            personRepository.delete(user);
            long end = System.currentTimeMillis() - start;
            System.out.println(methodName+" time: "+end);
        }
        catch (Exception ex) {
            return false;
        }

        return  true;
    }

    public Iterable<Person> saveUserList(Iterable<Person> users) {
        final String methodName = "saveUserList";
        long start = System.currentTimeMillis();
        users = personRepository.save(users);
        long end = System.currentTimeMillis() - start;
        System.out.println(methodName+" time: "+end);
        return  users;
    }

    public Person findOne(String nick) {
        final String methodName = "findOne";
        long start = System.currentTimeMillis();
        Person user = personRepository.findByNick(nick);
        long end = System.currentTimeMillis() - start;
        System.out.println(user);
        System.out.println(methodName+" time: "+end);
        return  user;
    }

    public Collection<Person> findByFirstName(String firstName) {
        final String methodName = "findByFirstName";
        long start = System.currentTimeMillis();
        Collection<Person> users = personRepository.findByFirstName(firstName);
        long end = System.currentTimeMillis() - start;
        System.out.println(methodName+" time: "+end+" size: " + users.size());
        return  users;
    }

    public boolean removeUserList(Collection<Person> user) {
        final String methodName = "removeUserList";
        long start = System.currentTimeMillis();
        try {
            personRepository.delete(user);
            long end = System.currentTimeMillis() - start;
            System.out.println(methodName+" time: "+end+" size: "+ user.size());
        }
        catch (Exception ex) {
            return false;
        }

        return  true;
    }
}
