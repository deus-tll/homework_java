package org.deus;

import org.deus.tasks.Task_1;
import org.deus.tasks.Task_2;
import org.deus.tasks.Task_3;
import org.deus.tasks.Task_4;

public class Main {
    public static void main(String[] args) {
        Task_1 task_1 = new Task_1();
        Task_2 task_2 = new Task_2();
        Task_3 task_3 = new Task_3();
        Task_4 task_4 = new Task_4();

        task_1.run();
        task_2.run();
        task_3.run();
        task_4.run();
    }
}