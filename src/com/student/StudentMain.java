package com.student;

import java.util.Scanner;

import com.student.dao.StudentDAO;
import com.student.dao.CourseDAO;
import com.student.dao.EnrollmentDAO;
import com.student.model.Student;
import com.student.model.Course;

public class StudentMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Add Course");
        System.out.println("4. View Courses");
        System.out.println("5. Enroll Student");
        System.out.println("6. View Enrollments");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:
                System.out.print("Enter name: ");
                String name = sc.nextLine();

                System.out.print("Enter email: ");
                String email = sc.nextLine();

                Student student = new Student(name, email);
                studentDAO.addStudent(student);
                break;

            case 2:
                studentDAO.viewAllStudents();
                break;

            case 3:
                System.out.print("Enter course name: ");
                String courseName = sc.nextLine();

                Course course = new Course(courseName);
                courseDAO.addCourse(course);
                break;

            case 4:
                courseDAO.viewAllCourses();
                break;

            case 5:
                System.out.print("Enter student ID: ");
                int studentId = sc.nextInt();

                System.out.print("Enter course ID: ");
                int courseId = sc.nextInt();

                enrollmentDAO.enrollStudent(studentId, courseId);
                break;

            case 6:
                enrollmentDAO.viewEnrollments();
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}

