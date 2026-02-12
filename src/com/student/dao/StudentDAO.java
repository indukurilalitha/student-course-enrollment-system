package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.student.model.Student;
import com.student.util.DBConnection;

public class StudentDAO {

    // Add Student
    public void addStudent(Student student) {

        String sql = "INSERT INTO students (name, email) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());

            ps.executeUpdate();
            System.out.println("✅ Student added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View All Students
    public void viewAllStudents() {

        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("---- STUDENT LIST ----");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("student_id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("email")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
