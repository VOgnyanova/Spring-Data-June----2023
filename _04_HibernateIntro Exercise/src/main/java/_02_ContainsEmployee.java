import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class _02_ContainsEmployee {
    private static final String DATABASE_NAME = "soft_uni";

    public static void main(String[] args) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(DATABASE_NAME);
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        final String[] name = new Scanner(System.in).nextLine().split(" ");
        String firstName = name[0];
        String lastName = name[1];

        final Long countOfMatches = entityManager.createQuery(
                        "select count(e) from Employee e where e.firstName = :fn AND e.lastName = :ln", Long.class)
                .setParameter("fn", firstName)
                .setParameter("ln", lastName)
                .getSingleResult();

        if (countOfMatches == 0 ){
            System.out.println("No");
        }else {
            System.out.println("Yes");
        }


    }
}
