import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import java.util.Scanner;
import java.util.Set;

public class _05_EmployeesFromDepartment {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        entityManager.getTransaction().begin();

        String lastName = scanner.nextLine();
        Set<Employee> employees = Set.copyOf(entityManager
                .createQuery("FROM Employee WHERE lastName = :lastName",Employee.class)
                .setParameter("lastName",lastName)
                .getResultList());

        Address newAddress = new Address();
        newAddress.setText("Vitoshka 15");

        entityManager.persist(newAddress);

        employees.forEach(employee -> employee.setAddress(newAddress));
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
        scanner.close();

    }
}
