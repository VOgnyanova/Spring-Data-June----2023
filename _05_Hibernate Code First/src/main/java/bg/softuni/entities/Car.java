package bg.softuni.entities;



import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class Car extends PassengerVehicle {
    private static final String CAR_TYPE = "CAR";

    public Car() {
        super(CAR_TYPE);
    }

    public Car(String model, String fuel_type, int seats){
     this();

     this.model = model;
     this.fuelType = fuel_type;
     this.seats = seats;
    }
}
