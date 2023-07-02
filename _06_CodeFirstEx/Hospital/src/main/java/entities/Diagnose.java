package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "diagnoses")

public class Diagnose extends BaseEntity {


    public Diagnose() {
        this.patients = new HashSet<>();
    }

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "comments", columnDefinition = "TEXT")
    private String comments;

    private Set<Patient> patients;


    @ManyToMany(mappedBy = "diagnoses")
    public Set<Patient> getPatients() {
        return patients;
    }

}