package org.example.respository;

import org.example.model.Student;

import java.sql.*;

public class StudentRepository {

    public void create() {

        String url = "jdbc:postgresql://localhost:5433/JDBC_Demo";
        String username = "postgres";
        String password = "gasmonkey";
        String sql = """
INSERT INTO students (name, email, age) VALUES (? ,? ,? )
""";
        try (  Connection connection = DriverManager.getConnection(url, username, password);  PreparedStatement statement = connection.prepareStatement(sql);
                     ){
            statement.setString(1, "Gasmonkey");
            statement.setString(2, "gas@gmail.com");
            statement.setInt(3, 30);

            int result = statement.executeUpdate();

            if (result == 1) {
                System.out.println("Student created successfully");
            }
        } catch (SQLException e) {
            System.out.println("Database connection could not be established...");
            e.printStackTrace();
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

            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            Student student = mapToStudent(resultSet);
            System.out.println(student);

            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection could not be established...");
            e.printStackTrace();
        }
    }

    private Student mapToStudent(java.sql.ResultSet resultSet) throws SQLException {

        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }
}
