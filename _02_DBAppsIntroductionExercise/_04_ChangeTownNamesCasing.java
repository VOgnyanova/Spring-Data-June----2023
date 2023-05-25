package _02_DBAppsIntroductionExercise;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class _04_ChangeTownNamesCasing {
    private static final String UPDATE_TOWN_NAMES =
            "UPDATE towns AS t SET name = UPPER(name) WHERE t.country = ?;";
    private static final String GET_TOWN_NAMES_BY_COUNTRY_NAME =
            "SELECT t.name from towns as t where t.country = ?";
    private static final String NO_TOWN_AFFECTED = "No town names were affected.";
    private static final String COUNT_TOWNS = "%d town names were affected.%n";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        final Connection connection = Utils.getSQLConnection();

        final String country_name = scanner.nextLine();

        final PreparedStatement statement = connection.prepareStatement(UPDATE_TOWN_NAMES);
        statement.setString(1, country_name);

        int updateCount = statement.executeUpdate();

        if (updateCount == 0) {
            System.out.println(NO_TOWN_AFFECTED);
            connection.close();
            return;
        }

        System.out.printf(COUNT_TOWNS, updateCount);
        PreparedStatement selectTowns = connection.prepareStatement(GET_TOWN_NAMES_BY_COUNTRY_NAME);
        selectTowns.setString(1, country_name);
        final ResultSet resultSet = selectTowns.executeQuery();


        ArrayList<String> towns = new ArrayList<>();
        while (resultSet.next()) {
            towns.add(resultSet.getString(Constants.COLUMN_LABEL_NAME));
        }
        System.out.println(towns);
    }
}
