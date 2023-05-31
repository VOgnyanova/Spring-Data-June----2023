import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();

      SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

//
//        Student example = new Student();
//        example.setName("Tosho");
//        session.persist(example);
//

        Student formDB = session.get(Student.class,3);
        System.out.println(formDB.getId()+ " " + formDB.getName());

      List<Student> students = session
              .createQuery("FROM Students as s WHERE s.name = 'Tosho'",Student.class).list();


        for (Student student : students) {
            System.out.println(student.getId()+ " " + student.getName());
        }
        session.getTransaction().commit();
        session.close();



    }
}