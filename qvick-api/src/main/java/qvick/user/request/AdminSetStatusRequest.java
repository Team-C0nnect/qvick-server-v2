package qvick.user.request;

import lombok.Getter;

@Getter
public class AdminSetStatusRequest {
    private String email;
    private Long status;
}
