package org.deus.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaxDatabase {
    private HashMap<String, List<Penalty>> database;

    public TaxDatabase() {
        database = new HashMap<>();
    }

    public void addPerson(String personalCode) {
        database.put(personalCode, new ArrayList<>());
    }

    public void addPenalty(String personalCode, Penalty penalty) {
        if (database.containsKey(personalCode)) {
            List<Penalty> penalties = database.get(personalCode);
            penalties.add(penalty);
        } else {
            System.out.println("Person with code " + personalCode + " was not found.");
        }
    }

    public void removePenalty(String personalCode, Penalty penalty) {
        if (database.containsKey(personalCode)) {
            List<Penalty> penalties = database.get(personalCode);
            penalties.remove(penalty);
        } else {
            System.out.println("Person with code " + personalCode + " was not found.");
        }
    }

    public void updatePersonInfo(String personalCode, List<Penalty> penalties) {
        if (database.containsKey(personalCode)) {
            database.put(personalCode, penalties);
        } else {
            System.out.println("Person with code " + personalCode + " was not found.");
        }
    }

    public void printDatabase() {
        for (String personalCode : database.keySet()) {
            System.out.println("Code: " + personalCode);
            System.out.println("Penalties:");
            List<Penalty> penalties = database.get(personalCode);
            for (Penalty penalty : penalties) {
                System.out.println("Type: " + penalty.getType() + ", City: " + penalty.getCity() + ", Amount: " + penalty.getAmount());
            }
            System.out.println();
        }
    }

    public void printDataByCode(String personalCode) {
        if (database.containsKey(personalCode)) {
            List<Penalty> penalties = database.get(personalCode);
            System.out.println("Code: " + personalCode);
            System.out.println("Penalties:");
            for (Penalty penalty : penalties) {
                System.out.println("Type: " + penalty.getType() + ", City: " + penalty.getCity() + ", Amount: " + penalty.getAmount());
            }
        } else {
            System.out.println("Person with code " + personalCode + " was not found.");
        }
    }

    public void printDataByPenaltyType(String type) {
        for (String personalCode : database.keySet()) {
            List<Penalty> penalties = database.get(personalCode);
            for (Penalty penalty : penalties) {
                if (penalty.getType().equals(type)) {
                    System.out.println("Code: " + personalCode + ", Type: " + penalty.getType() + ", City: " + penalty.getCity() + ", Amount: " + penalty.getAmount());
                    break;
                }
            }
        }
    }

    public void printDataByCity(String city) {
        for (String personalCode : database.keySet()) {
            List<Penalty> penalties = database.get(personalCode);
            for (Penalty penalty : penalties) {
                if (penalty.getCity().equals(city)) {
                    System.out.println("Code: " + personalCode + ", Type: " + penalty.getType() + ", City: " + penalty.getCity() + ", Amount: " + penalty.getAmount());
                    break;
                }
            }
        }
    }
}
