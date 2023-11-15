package bg.softuni.OgisticApp.repository;

import bg.softuni.OgisticApp.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
