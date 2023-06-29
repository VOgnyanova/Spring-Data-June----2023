import entities.Employee;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class _03_ContainsEmployee {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();
        Scanner scanner = new Scanner(System.in);
        String fullName = scanner.nextLine();

        entityManager.getTransaction().begin();

        String isEmployeePresented = entityManager
                .createQuery("FROM Employee where concat_ws(' ',first_name,last_name) = :fullName", Employee.class)
                .setParameter("fullName",fullName)
                .getResultList()
                .isEmpty() ? "No" : "Yes";

        entityManager.getTransaction().commit();

        System.out.println(isEmployeePresented);
    }
}
