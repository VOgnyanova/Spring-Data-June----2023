package _01_DBAppsIntroduction;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class countGames {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", properties);

        PreparedStatement stmt = connection.prepareStatement(
                "SELECT user_name, first_name, last_name, COUNT(users_games.id) as games_played FROM users" +
                        "  JOIN users_games ON users_games.user_id = users.id" +
                        "  WHERE user_name = ?" +
                        "  GROUP BY users_games.user_id;"
        );
        String username = scanner.nextLine();
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String dbUsername = rs.getString("user_name");
            String dbFirstName = rs.getString("first_name");
            String dbLastName = rs.getString("last_name");
            Integer dbGamesCount = rs.getInt("games_played");


            System.out.printf("User: %s\n%s %s has played %d games\n",
                    dbUsername, dbFirstName, dbLastName, dbGamesCount);
        } else {
            System.out.println("No such user exists");
        }
        connection.close();
    }
}
