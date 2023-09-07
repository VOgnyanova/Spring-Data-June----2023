package bg.softuni.mvc.dtos;

public class UserShortInfoDTO {
    private String username;

    public UserShortInfoDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
