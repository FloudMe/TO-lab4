package com.PopulationRecords;

import java.util.HashMap;

public class SurnameFlyweight {
    private final HashMap<String, Surname> surnameHashMap = new HashMap<String, Surname>();

    private boolean checkSurname(String surname)
    {
        boolean check = surname.contains("-");
        if (!check)
            check = surname.contains(" ");
        return check;
    }

    public Surname getSurname(String surname, String pesel)
    {
        boolean check = checkSurname(surname);
        if(check)
            return complexSurname(surname, pesel);
        else
            return simpleSurname(surname, pesel);
    }

    private Surname simpleSurname(String surname, String pesel) {
        Surname tempSurname = createSurname(surname);
        tempSurname.addPesel(pesel);
        return tempSurname;
    }

    private Surname createSurname(String surname)
    {
        Surname tempSurname = (Surname) surnameHashMap.get(surname);
        if(tempSurname == null)
        {
            tempSurname = new Surname(surname);
            surnameHashMap.put(surname, tempSurname);
        }
        return tempSurname;
    }

    private Surname complexSurname(String surname, String pesel) {

        return null;
    }

    public void deleteName()
    {
        for (HashMap.Entry<String, Surname> temp : surnameHashMap.entrySet())
        {
            temp.getValue().deleteName();
            surnameHashMap.remove(temp.getKey());
        }
    }

    public boolean deleteSurname(String surname) {
        try {
            surnameHashMap.get(surname).deleteSurname();
            surnameHashMap.remove(surname);
            return true;
        }catch (NullPointerException e) {
            return false;
        }
    }

    public boolean deletePerson(String surname, String pesel) {
        return surnameHashMap.get(surname).deletePerson(pesel);
    }

    public String searchForName()
    {
        StringBuilder tempString = new StringBuilder();

        for(HashMap.Entry<String, Surname> temp : surnameHashMap.entrySet())
        {
            tempString.append(" ");
            tempString.append(temp.getKey());
            tempString.append(temp.getValue().searchForName());

        }
        return tempString.toString();
    }

    public String searchForSurname(String surname) {
        return surnameHashMap.get(surname).searchForSurname();
    }

    public String searchForPerson(String surname, String pesel) {
        return surnameHashMap.get(surname).searchForPerson(pesel);
    }
}
