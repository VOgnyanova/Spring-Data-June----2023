package bg.softuni;


import bg.softuni.entities.Bike;
import bg.softuni.entities.Car;
import bg.softuni.entities.Plane;
import bg.softuni.entities.Vehicle;
import bg.softuni.hasEntities.Article;
import bg.softuni.hasEntities.PlateNumber;
import bg.softuni.hasEntities.Truck;
import bg.softuni.hasEntities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("relations");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Vehicle car = new Car("Ford Focus", "Petrol", 5);
        Vehicle bike = new Bike();
        Vehicle plane = new Plane("Airbus", "Petrol", 200);

        entityManager.persist(car);
        entityManager.persist(bike);
        entityManager.persist(plane);

        PlateNumber number = new PlateNumber("123");
        Truck truck1 = new Truck(number);
        Truck truck2 = new Truck(number);

        entityManager.persist(number);
        entityManager.persist(truck1);
        entityManager.persist(truck2);



        Article article = new Article("alabala");
        User author = new User("Toshko");

        author.addArticle(article);
        article.setAuthor(author);

        entityManager.persist(author);

        User user = entityManager.find(User.class, 2);

        System.out.println();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}