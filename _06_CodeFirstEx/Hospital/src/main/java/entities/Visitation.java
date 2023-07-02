package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "visitations")

public class Visitation extends BaseEntity {
    @Column(name = "date")
    private LocalDateTime dateTime;
    @Column(name = "comments", columnDefinition = "TEXT")
    private String comments;
    @ManyToOne
    private Set<Patient> patientSet;

    public Visitation() {}
}
