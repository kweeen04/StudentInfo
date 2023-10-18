package Controller;

import Repository.StudentRepository;
import View.Menu;
import Common.Library;

public class StudentController extends Menu<String> {
    static String[] mc = {"Add student", "Sort Students", "Exit"};
    StudentRepository studentRepository;
    Library l;

    public StudentController() {
        super("\nStudent Information Processing", mc);
        studentRepository = new StudentRepository();
        l = new Library();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                studentRepository.addStudent();
                break;
            case 2:
                studentRepository.sortStudent();
                break;
            case 3:
                System.exit(0);
        }
    }
}
