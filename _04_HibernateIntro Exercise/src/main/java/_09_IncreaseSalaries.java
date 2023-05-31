import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;


public class _09_IncreaseSalaries {
    public static void main(String[] args) {
        final EntityManager entityManager =
                Persistence.createEntityManagerFactory("soft_uni")
                        .createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.createQuery("UPDATE Employee e SET e.salary=e.salary*1.12 WHERE e.department.id IN :ids")
                .setParameter("ids", Arrays.asList(1, 2, 4, 11)).executeUpdate();
        entityManager.getTransaction().commit();

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee  e WHERE e.department.id IN :ids", Employee.class)
                .setParameter("ids", Arrays.asList(1, 2, 4, 11)).getResultList();
        employees.forEach(e -> System.out.printf("%s %s ($%.2f)%n", e.getFirstName(), e.getLastName(), e.getSalary()));
    }
}
