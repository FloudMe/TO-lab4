package com.PopulationRecords;

import java.util.ArrayList;
import java.util.Iterator;

public class People implements iIterator {
    private ArrayList<Person> people;

    public People()
    {
        people = new ArrayList<Person>();
    }

    public void addPerson(String name, String surname, String pesel)
    {
        people.add(new Person(name, surname, pesel));
    }

    public void deleteName(String name)
    {
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            if (person.getName().getStringName().equals(name)) {
                person.deleteName();
                people.remove(i);
                i-=1;
            }
        }
    }

    public boolean searchForName(String name)
    {
        for (Person person : people) {
            if (person.getName().getStringName().equals(name)) {
                System.out.println(person.searchForName());
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator createIterator() {
        return people.iterator();
    }

}
