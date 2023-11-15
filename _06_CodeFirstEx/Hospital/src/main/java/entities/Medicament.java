package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "medicaments")
public class Medicament extends BaseEntity {

    @Column(name = "name",nullable = false)
    private String name;

    public Medicament() {
    }
}
