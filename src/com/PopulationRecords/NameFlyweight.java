package com.PopulationRecords;

import java.util.HashMap;

public class NameFlyweight {
    private static final HashMap<String, Name> nameHashMap = new HashMap<String, Name>();

    public static Name getName(String name, String surname, String pesel)
    {
        Name tempName = (Name) nameHashMap.get(name);

        if(tempName == null)
        {
            tempName = new Name(name);
            tempName.addSurname(surname, pesel);
            nameHashMap.put(name, tempName);
        }
        else
        {
            tempName.addSurname(surname, pesel);
        }
        return tempName;
    }

    public static void deleteName(String name){
        nameHashMap.remove(name);
    }
}
