package roman.pidkostelny.dealer.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String login;

    private String password;
}
