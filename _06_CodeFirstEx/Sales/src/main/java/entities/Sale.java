package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Sale extends BaseEntity {


    @ManyToOne
    private Product product;

    @OneToMany
    private List<Product> test;


    @ManyToOne
    private Customer customer;


    @ManyToOne
    private StoreLocation storeLocation;

    @Column
    private Date date;
}