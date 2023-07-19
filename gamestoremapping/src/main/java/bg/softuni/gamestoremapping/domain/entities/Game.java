package bg.softuni.gamestoremapping.domain.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "games")
public class Game extends BaseEntity {
    @Column(nullable = false)
    private String title;

    @Column
    private String trailer;

    @Column
    private String imageThumbnail;

    @Column
    private float size;

    @Column(nullable = false)
    private BigDecimal price;

    @Column
    private String description;

    @Column
    private LocalDate releaseDate;

}
