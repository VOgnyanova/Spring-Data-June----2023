package bg.softuni.OgisticApp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "deliveries")
public class Delivery extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    DeliveryMethod deliveryMethod;
    @NotNull
    private String description;

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
