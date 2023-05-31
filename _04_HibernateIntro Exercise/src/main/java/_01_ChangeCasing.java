import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class _01_ChangeCasing {
    private static final String DATABASE_NAME = "soft_uni";
    private static final String UPDATE_ALL_TOWNS_WITH_LENGTH_MORE_THAN_5 = "UPDATE Town  t SET t.name = UPPER(t.name) WHERE length(t.name) <= 5";

    public static void main(String[] args) {

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(DATABASE_NAME);
        final EntityManager entityManager = entityManagerFactory.createEntityManager();


        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery(UPDATE_ALL_TOWNS_WITH_LENGTH_MORE_THAN_5);


        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
