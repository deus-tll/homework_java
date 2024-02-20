package org.deus;

import org.deus.task_3.Penalty;
import org.deus.task_3.TaxDatabase;

public class Main_Task_3 {
    public static void main(String[] args) {
        TaxDatabase taxDatabase = new TaxDatabase();
        taxDatabase.addPerson("1234567890");
        taxDatabase.addPenalty("1234567890", new Penalty("Паркування", "Київ", 100.0));
        taxDatabase.printDatabase();
        taxDatabase.printDataByCode("1234567890");
        taxDatabase.printDataByPenaltyType("Паркування");
        taxDatabase.printDataByCity("Київ");
    }
}
