import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class _11_EmployeesMaxSalaries {
    public static void main(String[] args) {

        final EntityManager entityManager =
                Persistence.createEntityManagerFactory("soft_uni")
                        .createEntityManager();




        List<Object[]> resultList = entityManager.createNativeQuery
                ("SELECT  d.name, MAX(e.salary) from  departments as d join employees e on d.department_id = e.department_id\n" +
                "GROUP BY d.name\n" +
                "HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000;")
                .getResultList();

        resultList.forEach(r-> System.out.println(r[0]+" "+r[1]));
    }
}
