package com.PopulationRecords;

public class Main
{
    public static void main(String[] args)
    {
        People p = new People();
        PeopleIterator pp = new PeopleIterator(p);

        p.addPerson("Tomek","Kowalski","11111111111");

        pp.searchForName("Tomek");
        pp.deletePerson("Tomek","Kowalski","11111111111");
        pp.searchForName("Tomek");
        pp.deleteSurname("Nowak");
    }
}
