package qvick.post.exception;

import qvick.exception.BusinessException;
import qvick.post.exception.error.PostError;

public class PostExistException extends BusinessException {

    public static final PostExistException EXCEPTION = new PostExistException();

    private PostExistException() {
        super(PostError.POST_EXIST);
    }

}
