package bg.softuni.gamestoremapping.domain.entities.models;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class GameAddDto {
    private String title;
    private BigDecimal price;
    private float size;
    private String trailer;
    private String imageThumbnail;
    private String description;
    private LocalDate releaseDate;

    public GameAddDto(String title, BigDecimal price, float size, String trailer, String thubnailURL, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.imageThumbnail = thubnailURL;
        this.description = description;
        this.releaseDate = releaseDate;

    }


    @Pattern(regexp = "[A-Z][\\w\\d\\s\\.]{3,100}", message = "Title – has to begin with an uppercase letter and must have length between 3 and 100 symbols ")
    public String getTitle() {
        return title;
    }

    @DecimalMin(value = "0", message = "Must be a positive number")
    public BigDecimal getPrice() {
        return price;
    }
    @Positive(message = "Must be a positive number")
    public Float getSize() {
        return size;
    }

    @Size(min = 11, max = 11, message = "Enter valid trailer. Exactly 11 characters")
    public String getTrailer() {
        return trailer;
    }
    @Pattern(regexp = "(https?\\:\\/\\/.*)", message = "Enter valid path. Must starting with http://, https://")
    public String getThumbnailURL() {
        return imageThumbnail;
    }
    @Size(min = 20, message = "Enter valid description. Must be at least 20 symbols")
    public String getDescription() {
        return description;
    }

    public String successfullyAddedGame() {
        return "Added " + this.title;
    }
}