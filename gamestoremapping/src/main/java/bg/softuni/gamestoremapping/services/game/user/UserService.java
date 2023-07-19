package bg.softuni.gamestoremapping.services.game.user;

public interface UserService {
    String registerUser(String[] args);
    String loginUser(String[] args);
    String logoutUser();
    boolean isLoggedUserAdmin();
}
