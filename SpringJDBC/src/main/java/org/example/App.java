package org.example;

import org.example.Service.StudentService;
import org.example.Service.StudentServiceImpl;
import org.example.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;


public class App {

    public static void main(String[] args) throws SQLException {

            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            StudentService service=context.getBean("service", StudentServiceImpl.class);
            Student student1 = new Student("1","SJ","BR");
        Student student2 = new Student("2","Raj","SH");
            //student1=service.createStudent(student1);
           // student2=service.createStudent(student2);

            //System.out.println(student1);
            //System.out.println(student2);
       // service.removeStudent(2);
        //service.updateStudent(1);
        List<Student> student3= service.getAllStudents();
        System.out.println(student3);

        }


}
