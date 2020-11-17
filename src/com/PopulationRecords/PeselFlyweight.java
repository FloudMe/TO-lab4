package com.PopulationRecords;

import java.util.HashMap;

public class PeselFlyweight {
    private static final HashMap<String,Pesel> peselHashMap=new HashMap<String, Pesel>();

    public static Pesel getPesel(String pesel)
    {
        Pesel tempPesel=(Pesel) peselHashMap.get(pesel);

        if(tempPesel == null){
            tempPesel = new Pesel(pesel);
            peselHashMap.put(pesel, tempPesel);
            return tempPesel;
        }else{
            throw new RuntimeException("Osoba o takim peselu juz istnieje");
        }
    }

    public static String searchForPerson(String pesel) {
        return peselHashMap.get(pesel).toString();
    }

    public static void deletePesel(String key) {
        peselHashMap.remove(key);
    }
}
