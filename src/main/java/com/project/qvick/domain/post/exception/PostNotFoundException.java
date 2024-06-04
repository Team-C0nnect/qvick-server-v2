package com.project.qvick.domain.post.exception;

import com.project.qvick.domain.post.exception.error.PostError;
import com.project.qvick.global.exception.BusinessException;

public class PostNotFoundException extends BusinessException {

    public static final PostNotFoundException EXCEPTION = new PostNotFoundException();

    private PostNotFoundException() {
        super(PostError.POST_NOT_FOUND);
    }

}
