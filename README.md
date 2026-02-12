# Student Course Enrollment System

A Java-based backend application that manages students, courses, and enrollments using JDBC and MySQL.

---

## 🚀 Features

- Add and view students
- Add and view courses
- Enroll students into courses
- View enrollments using JOIN queries
- Implements many-to-many relationship
- Uses PreparedStatement to prevent SQL injection

---

## 🛠 Tech Stack

- Java 17
- MySQL 8
- JDBC (MySQL Connector/J)
- Eclipse IDE

---

## 🗄 Database Design

### Tables:

- **students** (student_id, name, email)
- **courses** (course_id, course_name)
- **enrollments** (enrollment_id, student_id, course_id)

Implements many-to-many relationship using foreign keys.

---

## ▶ How to Run

1. Create database `student_enrollment_db`
2. Create tables (students, courses, enrollments)
3. Update DB credentials in `DBConnection.java`
4. Run `StudentMain.java`

---

## 👩‍💻 Author

Indukuri Lalitha
