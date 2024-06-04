package com.project.qvick.domain.post.exception;

import com.project.qvick.domain.post.exception.error.PostError;
import com.project.qvick.global.exception.BusinessException;

public class PostExistException extends BusinessException {

    public static final PostExistException EXCEPTION = new PostExistException();

    private PostExistException() {
        super(PostError.POST_EXIST);
    }

}
