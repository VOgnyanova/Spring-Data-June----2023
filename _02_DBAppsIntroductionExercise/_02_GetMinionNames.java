package _02_DBAppsIntroductionExercise;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class _02_GetMinionNames {


    private static final String GET_MINIONS_NAME_AGE = "select m.name,m.age from minions as m\n"
            + " join minions_villains as mv on m.id = mv.minion_id "
            + " where villain_id = ? ";
    private static final String COLUMN_LABEL_AGE = "age";

    private static final String GET_VILLAINS_NAME = "select name from villains " + " where id = ?";
    private static final String PRINT_FORMAT_VILLAIN = "Villain: %s%n";
    private static final String PRINT_FORMAT_MINIONS = "%d. %s %d%n";
    private static String NO_VILLAIN_FORMAT = "No villain with ID %d exists in the database.";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);


        final Connection connection = Utils.getSQLConnection();

        final int id = scanner.nextInt();

        final PreparedStatement villainStatement = connection.prepareStatement(GET_VILLAINS_NAME);

        villainStatement.setInt(1, id);
        final ResultSet resultSet = villainStatement.executeQuery();

        if (!resultSet.next()) {
            System.out.printf(NO_VILLAIN_FORMAT, id);
            connection.close();
            return;
        }

        final String villainName = resultSet.getString(Constants.COLUMN_LABEL_NAME);
        System.out.printf(PRINT_FORMAT_VILLAIN, villainName);

        final PreparedStatement minionStatement = connection.prepareStatement(GET_MINIONS_NAME_AGE);
        minionStatement.setInt(1, id);

        final ResultSet minionSet = minionStatement.executeQuery();

        for (int index = 1; minionSet.next(); index++) {
            final String minionName = minionSet.getString(Constants.COLUMN_LABEL_NAME);
            final int minionAge = minionSet.getInt(COLUMN_LABEL_AGE);

            System.out.printf(PRINT_FORMAT_MINIONS,index,minionName,minionAge);
        }
        connection.close();

    }

}

