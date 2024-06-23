package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InitData {
    private static Connection connection;
    public static void createTourTable() {
        if(connection != null) {
            try {
                String createTour = "CREATE TABLE Tour (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "code VARCHAR(10)," +
                        "name VARCHAR(50)," +
                        "description VARCHAR(50)";
                Statement statement = connection.createStatement();

                statement.execute(createTour);
                System.out.println("CREATE TABLE 'Tour' successfully");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void dropTourTable() {
        if(connection != null) {
            try {
                String dropTour = "DROP TABLE Tour";
                Statement statement = connection.createStatement();
                statement.execute(dropTour);
                System.out.println("DROP TABLE 'Tour' successfully");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void insertGem(String code, String name, String title) {
        if(connection != null) {
            try {
                String tour = "INSERT INTO Gemstone (code, name, description, image) VALUES (?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(tour);
                statement.setString(1, code);
                statement.setString(2, name);
                statement.setString(3, title);
                statement.executeUpdate();
                System.out.println("INSERTED 1 row(s) in table 'Gemstone'");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void initTourData() {
        String[] code = {"QZT001", "MS001", "HN001"};
        String[] name = {"Thạch anh trắng", "Đá mặt trăng", "Ngọc lục bảo"};
        String[] title = {"Thạch anh trắng", "Đá mặt trăng", "Ngọc lục bảo"};
        for(int i = 0; i < code.length; i++) {
            insertGem(code[i], name[i], title[i]);
        }
    }

    public static void main(String[] args) {
        connection = DatabaseConnection.getConnection();
        initTourData();
    }
}
