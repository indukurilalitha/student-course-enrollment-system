package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.student.model.Course;
import com.student.util.DBConnection;

public class CourseDAO {

    // Add Course
    public void addCourse(Course course) {

        String sql = "INSERT INTO courses (course_name) VALUES (?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, course.getCourseName());
            ps.executeUpdate();

            System.out.println("Course added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View All Courses
    public void viewAllCourses() {

        String sql = "SELECT * FROM courses";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("---- COURSE LIST ----");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("course_id") + " | " +
                    rs.getString("course_name")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
