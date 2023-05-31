import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class _10_FindEmployeesByFirstName {
    public static void main(String[] args) {
        final EntityManager entityManager =
                Persistence.createEntityManagerFactory("soft_uni")
                        .createEntityManager();


        final Scanner scanner = new Scanner(System.in);
        final String pattern = scanner.nextLine();

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee  e WHERE e.firstName LIKE :pattern", Employee.class)
                .setParameter("pattern", pattern.concat("%")).getResultList();

        employees.forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n",
                e.getFirstName(),
                e.getLastName(),
                e.getJobTitle(),
                e.getSalary()));
    }
}
