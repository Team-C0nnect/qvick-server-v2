package qvick.post.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostEditRequest {

    private Long postId;
    private String title;
    private String content;

}
