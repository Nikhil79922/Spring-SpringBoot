package com.example.springJDBCdemo.respository;



import com.example.springJDBCdemo.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create() {

        String sql = """

INSERT INTO students (name, email, age) VALUES (? ,? ,? )
""";
        int result = jdbcTemplate.update(sql, "Nikhil" , "king@gmail.com" , 22);

        if (result == 1) {
            System.out.println("Student created successfully");
        }
    }

    public void update() {

        String url = "jdbc:postgresql://localhost:5433/JDBC_Demo";
        String username = "postgres";
        String password = "gasmonkey";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String sql = "UPDATE students SET age = 23 WHERE id = 1";

            int result = statement.executeUpdate(sql);

            if (result == 1) {
                System.out.println("Student updated successfully");
            } else {
                System.out.println("Student update failed");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection could not be established...");
            e.printStackTrace();
        }
    }

    public void delete() {

        String url = "jdbc:postgresql://localhost:5433/JDBC_Demo";
        String username = "postgres";
        String password = "gasmonkey";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String sql = "DELETE FROM students WHERE id = 1";

            int result = statement.executeUpdate(sql);

            if (result == 1) {
                System.out.println("Student deleted successfully");
            } else {
                System.out.println("Student delete failed");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection could not be established...");
            e.printStackTrace();
        }
    }

    public void getByID() {

        String url = "jdbc:postgresql://localhost:5433/JDBC_Demo";
        String username = "postgres";
        String password = "gasmonkey";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String sql = "SELECT id , name , email , age FROM students WHERE id = 3";

            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            Student student = mapToStudent(resultSet);
            System.out.println(student);

            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection could not be established...");
            e.printStackTrace();
        }
    }

    private Student mapToStudent(ResultSet resultSet) throws SQLException {

        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }
}
