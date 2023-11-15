package bg.softuni.OgisticApp.repository;

import bg.softuni.OgisticApp.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
