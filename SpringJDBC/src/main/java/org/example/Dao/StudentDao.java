package org.example.Dao;

import org.example.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
   public Student createStudent(Student student) throws SQLException;

   public void removeStudent(int studentId) throws SQLException;
   public void updateStudent(int studentId) throws SQLException;
   public List<Student> getAllStudents() throws SQLException;
}
