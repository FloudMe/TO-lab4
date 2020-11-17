package com.PopulationRecords;

public class Name
{
    private String name;
    private SurnameFlyweight surnameList = new SurnameFlyweight();

    public Name(String name)
    {
        this.name = name;
    }

    public String getStringName(){
        return name;
    }

    public void addSurname(String surname, String pesel)
    {
        surnameList.getSurname(surname, pesel);
    }

    public void deleteName() {
        surnameList.deleteName();
    }

    public boolean deleteSurname(String surname)
    {
        return surnameList.deleteSurname(surname);
    }

    public boolean deletePerson(String surname, String pesel)
    {
        return surnameList.deletePerson(surname, pesel);
    }

    public String searchForName()
    {
        return surnameList.searchForName();
    }

    public String searchForSurname(String surname)
    {
        return surnameList.searchForSurname(surname);
    }

    public String searchForPerson(String surname, String pesel)
    {
        return surnameList.searchForPerson(surname, pesel);
    }

    @Override
    public String toString() {
        return " Name: "+name;
    }
}
