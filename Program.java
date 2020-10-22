package ru.sapteh;

import java.sql.*;

public class Program {
    public static void  main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/worlds?user=root&password=1111&serverTimezone=UTC")){
            String sql = "SELECT * FROM country";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                int idCountry = result.getInt("id_country");
                String nameCountry = result.getString("nameCountry");
                int quantyCity = result.getInt("quantyCity");
                System.out.printf("%d| \t%s | %d| \n",idCountry,nameCountry,quantyCity);
            }
        }
    }
}

