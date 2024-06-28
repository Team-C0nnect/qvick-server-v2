package qvick.post.request;

import com.project.qvick.global.common.client.dto.request.PageRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostSearchRequest extends PageRequest {

    private String title;

}
