package library;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryModel {
    private Connection connection;

    public LibraryModel() {
        try {
            // Connect to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a book to the library
    public void addBook(String title, String author) {
        String sql = "INSERT INTO books (title, author) VALUES (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, author);
            statement.executeUpdate();
            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to display all books in the library
    public void displayBooks() {
        String sql = "SELECT * FROM books";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Title: " + resultSet.getString("title") + ", Author: " + resultSet.getString("author"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


