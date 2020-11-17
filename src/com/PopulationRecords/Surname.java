package com.PopulationRecords;

import java.util.HashMap;

public class Surname
{
    private String surname;
    HashMap<String, Pesel> peselHashMap = new HashMap<String, Pesel>();

    public Surname(String surname)
    {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void addPesel(String pesel)
    {
        peselHashMap.put(pesel, PeselFlyweight.getPesel(pesel));
    }

    public boolean delete()
    {
        for(HashMap.Entry<String, Pesel> temp : peselHashMap.entrySet())
        {
            PeselFlyweight.deletePesel(temp.getKey());
            peselHashMap.remove(temp.getKey());
        }
        return true;
    }
    public void deleteName() {
        delete();
    }

    public boolean deleteSurname() {
        return delete();
    }

    public boolean deletePerson(String pesel) {
        try {
            peselHashMap.remove(pesel);
            PeselFlyweight.deletePesel(pesel);
            return true;
        }catch (RuntimeException e)
        {
            return false;
        }
    }

    public String searchForName() {
        return searchForSurname();
    }

    public String searchForSurname() {
        StringBuilder tempPesel = new StringBuilder();
        for (HashMap.Entry<String, Pesel> temp : peselHashMap.entrySet()) {
            tempPesel.append(" ");
            tempPesel.append(peselHashMap.get(temp.getKey()));
        }
        return tempPesel.toString();
    }

    public String searchForPerson(String pesel)
    {
        return PeselFlyweight.searchForPerson(pesel);
    }

    @Override
    public String toString() {
        return " Surname: "+surname;
    }

}
