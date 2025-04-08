package br.edu.lab5.ex2;

import java.util.List;

public class Person {
    private int id;
    private String name;
    private int age;
    private List<Email> emails;

    public Person(int id, String name, int age, List<Email> emails) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Email> getEmails() {
        return emails;
    }

}
