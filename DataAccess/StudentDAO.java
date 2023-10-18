package DataAccess;

import java.util.ArrayList;
import java.util.Collections;

import Common.Library;
import Model.Student;

public class StudentDAO {
    private static StudentDAO instance = null;
    private Library library;

    private ArrayList<Student> students = new ArrayList<>();

    public StudentDAO() {
        library = new Library();
    }

    public static StudentDAO Instance() {
        if (instance == null) {
            synchronized (StudentDAO.class) {
                if (instance == null) {
                    instance = new StudentDAO();
                }
            }
        }
        return instance;
    }

    public void addStudent() {
        while (true) {
            String name = library.inputString("Enter student's name: ");
            float mark = library.checkInputFloat("Enter student's mark: ");
            String classes = library.inputString("Enter student's class: ");
            students.add(new Student(name, mark, classes));

            boolean addMore = library.checkInputYN("Do you want to enter more student information? (Y/N): ");
            if (!addMore) {
                break;
            }
        }
    }


    public void sortStudent() {
        if (students.isEmpty()) {
            System.out.println("No students to sort.");
            return;
        }
        Collections.sort(students);

        System.out.println("Student sorted by name (A to Z): ");
        for (int i = 0; i < students.size(); i++) {
            System.out.println("-------------Student " + (i + 1) + "-------------");
            System.out.println("Name: " + students.get(i).getName());
            System.out.println("Mark: " + students.get(i).getMark());
            System.out.println("Class: " + students.get(i).getClasses());
        }
    }
}
