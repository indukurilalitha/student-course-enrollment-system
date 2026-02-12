package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.student.util.DBConnection;

public class EnrollmentDAO {

    // Enroll student into course
    public void enrollStudent(int studentId, int courseId) {

        String sql = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            ps.executeUpdate();
            System.out.println("Student enrolled successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Enrollments using JOIN
    public void viewEnrollments() {

        String sql = """
                SELECT s.name, c.course_name
                FROM enrollments e
                JOIN students s ON e.student_id = s.student_id
                JOIN courses c ON e.course_id = c.course_id
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("---- ENROLLMENT LIST ----");

            while (rs.next()) {
                System.out.println(
                        rs.getString("name") +
                        " enrolled in " +
                        rs.getString("course_name")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
