package qvick.user.exception;

import qvick.exception.BusinessException;
import qvick.user.exception.error.UserError;

public class UserNotFoundException extends BusinessException {

    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException(){
        super(UserError.USER_NOT_FOUND);
    }

}
