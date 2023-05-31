import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

public class _08_FindLatest10Projects {
    public static void main(String[] args) {
        final EntityManager entityManagerFactory =
                Persistence.createEntityManagerFactory("soft_uni")
                        .createEntityManager();


        List<Project> projects = entityManagerFactory.createQuery("SELECT p FROM Project p ORDER BY p.startDate DESC ", Project.class)
                .setMaxResults(10)
                .getResultList();

        projects.stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> {
                    System.out.printf("Project name: %s%n", p.getName());
                    System.out.printf(" \tProject Description: %s%n", p.getDescription());
                    System.out.printf(" \tProject Start Date:%s%n", p.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.s")));
                    System.out.printf(" \tProject End Date:%s%n", p.getEndDate() == null ? "null" : p.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.s")));
                });
    }
}
