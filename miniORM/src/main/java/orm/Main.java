package orm;

import entities.User;
import orm.Connector;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException {
        Connector.createConnection("root", "12345", "soft_uni");
        Connection connection = Connector.getConnection();

        EntityManager<User> userManager = new EntityManager<>(connection);

        User user = new User("First",28, LocalDate.now());

        userManager.persist(user);

    }
}