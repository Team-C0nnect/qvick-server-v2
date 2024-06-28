package qvick.user.request;

import com.project.qvick.global.common.client.dto.request.PageRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchRequest extends PageRequest {

    private String name;

}
