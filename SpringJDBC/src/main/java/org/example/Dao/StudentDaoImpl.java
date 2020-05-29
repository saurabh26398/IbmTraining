package org.example.Dao;

import com.sun.javafx.geom.Curve;
import org.example.Factory.StudentFactory;
import org.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDaoImpl implements StudentDao {
    private StudentFactory factory;
    private Connection connection;
    Scanner scanner=new Scanner(System.in);
    public StudentDaoImpl(StudentFactory factory) throws SQLException {
        this.factory = factory;
        connection=factory.getMyConnection();
    }


    public Student createStudent(Student student) throws SQLException {
        PreparedStatement preparedStatement=connection.prepareStatement("insert into STUDENT_DATA(id,first_name,last_name)values(?,?,?)");
        preparedStatement.setString(1,student.getStudentID());
        preparedStatement.setString(2,student.getFirstName());
        preparedStatement.setString(3,student.getLastName());

        preparedStatement.executeUpdate();
        return student;
    }

    @Override
    public void removeStudent(int studentId) throws SQLException {
        PreparedStatement preparedStatement=connection.prepareStatement("delete from STUDENT_DATA where id=?");
        preparedStatement.setString(1, String.valueOf(studentId));
        preparedStatement.executeUpdate();
        System.out.println("removed");

    }

    @Override
    public void updateStudent(int studentId) throws SQLException {
        PreparedStatement
                preparedStatement=connection.prepareStatement("select * from STUDENT_DATA where id=?");
        preparedStatement.setString(1, String.valueOf(studentId));
        ResultSet rs=preparedStatement.executeQuery();
        int item=0;
        while(rs.next())
        {
            item++;
        }
        if(item<=0) {
            System.out.println("No Such Employee with the given id: "+studentId);

        }

        System.out.print("First Name:");

        String fName = scanner.next();
        System.out.print("Last Name :");
        String lName = scanner.next();


        preparedStatement=connection.prepareStatement("update STUDENT_DATA set first_name=?,last_name=? where id=?");
        preparedStatement.setString(1, fName);
        preparedStatement.setString(2, lName);

        preparedStatement.setString(3, String.valueOf(studentId));
        preparedStatement.executeUpdate();
        System.out.println("updated");
    }

    public List<Student> getAllStudents() throws SQLException {
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from STUDENT_DATA");
       List<Student> student= new ArrayList<Student>() ;
        while(resultSet.next())
        {
            student.add(new Student(resultSet.getString("id"),resultSet.getString("first_name"),resultSet.getString("last_name")));
        }
        return student;
    }
}

