package task3;


import java.util.ArrayList;
import java.util.Arrays;


public class Main {


    public static void main(String[] args) throws InterruptedException {
        int weeksAmount = 4;

        var groups = new ArrayList<>(Arrays.asList(
                new Group("ІP-02", 3, weeksAmount),
                new Group("ІT-03", 3, weeksAmount),
                new Group("ІP-04", 3, weeksAmount)
        ));
        ElectronicJournal journal = new ElectronicJournal(groups);

        var threads = new ArrayList<Thread>();
        for (int i = 0; i < weeksAmount; i++) {
            final int finalWeek = i;
            final Thread t = new Thread(() -> {
                for (Group group : groups) {
                    for (Integer student : group.getGrades().keySet()) {
                        var mark = (int) (Math.random() * 100) + 1;
                        group.addGrade(student, mark, finalWeek);
                        System.out.println("Thread: " + Thread.currentThread().getName() + " Added mark " + mark +
                                " to student " + student + " of group " + group.getGroupCode() +
                                " for week " + finalWeek);
                    }
                }
            });
            t.start();
            threads.add(t);
        }

        for (Thread thread : threads) {
            thread.join();
        }
        journal.printMarks();
    }
}

