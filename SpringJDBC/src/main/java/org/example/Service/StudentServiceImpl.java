package org.example.Service;

import org.example.Dao.StudentDao;
import org.example.model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao dao;

    public StudentServiceImpl(StudentDao dao ){
        this.dao= dao;
    }

    public Student createStudent(Student student) throws SQLException {
        return dao.createStudent(student);
    }

    public void removeStudent(int studentId) throws SQLException {
        dao.removeStudent(studentId);
    }
    public void updateStudent(int studentId) throws SQLException {
       dao.updateStudent(studentId);
    }
    public List<Student> getAllStudents() throws SQLException{
        return dao.getAllStudents();
    }
}