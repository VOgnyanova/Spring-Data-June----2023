package bg.softuni.OgisticApp.repository;

import bg.softuni.OgisticApp.model.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
