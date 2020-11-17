package com.PopulationRecords;

public class Person {
    private Name name;

    public Person(String name, String surname, String pesel)
    {
        this.name = NameFlyweight.getName(name, surname, pesel);
    }

    public Name getName()
    {
        return name;
    }

    public String searchForName()
    {
        return name + " " + name.searchForName();
    }

    public boolean searchForSurname(String surname)
    {
        try{
            name.searchForSurname(surname);
            return true;
        }catch (RuntimeException e) {
            return false;
        }
    }

    public String searchForPerson(String surname, String pesel)
    {
        return name + " " + name.searchForPerson(surname, pesel);
    }

    public void deleteName()
    {
        NameFlyweight.deleteName(name.getStringName());
        name.deleteName();
    }

    public boolean deleteSurname(String surname)
    {
        return name.deleteSurname(surname);
    }

    public boolean deletePerson(String surname, String pesel)
    {
        return name.deletePerson(surname, pesel);
    }

}
