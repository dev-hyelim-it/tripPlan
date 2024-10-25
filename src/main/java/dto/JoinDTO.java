package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinDTO {
    private String username;
    private String userId;
    private String password;
    private String passwordCheck;
    private String email;
    private String nickname;
}
