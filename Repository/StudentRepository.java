package Repository;

import DataAccess.StudentDAO;

public class StudentRepository implements IStudentRepository {
    @Override
    public void addStudent() {
        StudentDAO.Instance().addStudent();
    }

    @Override
    public void sortStudent() {
        StudentDAO.Instance().sortStudent();
    }
}
