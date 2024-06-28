package qvick.post.exception;

import qvick.exception.BusinessException;
import qvick.post.exception.error.PostError;

public class PostNotFoundException extends BusinessException {

    public static final PostNotFoundException EXCEPTION = new PostNotFoundException();

    private PostNotFoundException() {
        super(PostError.POST_NOT_FOUND);
    }

}
