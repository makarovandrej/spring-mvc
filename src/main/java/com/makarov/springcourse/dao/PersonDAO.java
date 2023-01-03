package com.makarov.springcourse.dao;

import com.makarov.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    // DAO - Data access object - pattern
    private List<Person> people;
    private static int PEOPLE_COUNT;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom", 10));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 20));
        people.add(new Person(++PEOPLE_COUNT, "James", 27));
        people.add(new Person(++PEOPLE_COUNT, "John", 43));
        people.add(new Person(++PEOPLE_COUNT, "Andrew", 28));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdate = show(id);
        personToBeUpdate.setName(updatedPerson.getName());
        personToBeUpdate.setAge(updatedPerson.getAge());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }

}
