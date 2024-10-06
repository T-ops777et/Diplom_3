package models;
import lombok.Data;

@Data
public class ResponseUser {
    private boolean success;
    private User user;
    private String accessToken;
    private String refreshToken;
}