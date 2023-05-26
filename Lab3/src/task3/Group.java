package task3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Group {
    private String groupCode;
    private int numWeeks;
    public HashMap<Integer, ArrayList<Integer>> grades = new HashMap<>();

    public Group(String groupCode, int numStudents, int numWeeks){
        this.groupCode = groupCode;
        this.numWeeks = numWeeks;

        for (int i = 0; i < numStudents; i++) {
            grades.put(i + 1, new ArrayList<>(Collections.nCopies(numWeeks, 0)));
        }
    }

    public void addGrade(Integer num, Integer grade, int week) {
        synchronized (grades.get(num)) {
            ArrayList<Integer> studentMarks = grades.get(num);
            if (week >= 0 && week < numWeeks) {
                studentMarks.set(week, grade);
            } else {
                throw new IllegalArgumentException("Invalid week: " + week);
            }
        }
    }

    public String getGroupCode() {
        return groupCode;
    }

    public int getNumWeeks() {
        return numWeeks;
    }

    public HashMap<Integer, ArrayList<Integer>> getGrades() {
        return grades;
    }
}