import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;

public class _07_GetEmployeeWithProject {
    public static void main(String[] args) {
        final EntityManager entityManagerFactory =
                Persistence.createEntityManagerFactory("soft_uni")
                        .createEntityManager();


        final Scanner scanner = new Scanner(System.in);
        final int id  = scanner.nextInt();

        System.out.println(entityManagerFactory.createQuery("SELECT e FROM Employee e WHERE e.id = :id", Employee.class)
                .setParameter("id",id)
                .getSingleResult()
                .toString());

    }
}
