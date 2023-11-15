package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {
    @Column(name = "first_name", nullable = false)

    private String firstName;
    @Column(name = "last_name", nullable = false)

    private String lastName;
    @Column(name = "address", nullable = false)

    private String address;
    @Column
    private String email;
    @Column
    private LocalDate dateOfBirth;
    @Column
    private String picturePath;
    @Column
    private Boolean hasInsurance;

    private Set<Visitation> visitation;
    private Set<Diagnose> diagnoses;
    private Set<Medicament> medicaments;

    public Patient() {
        this.visitation = new HashSet<>();
        this.diagnoses = new HashSet<>();
        this.medicaments = new HashSet<>();
    }

    @OneToMany(mappedBy = "patient")
    public Set<Visitation> getVisitation() {
        return visitation;
    }

    @ManyToMany
    @JoinTable(name = "patients_diagnoses",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "diagnose_id", referencedColumnName = "id"))
    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }


    @ManyToMany
    @JoinTable(name = "patients_medicaments",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medicament_id", referencedColumnName = "id"))
    public Set<Medicament> getMedicaments() {
        return medicaments;
    }


}
