package qvick.user.exception;

import qvick.exception.BusinessException;
import qvick.user.exception.error.UserError;

public class UserExistException extends BusinessException {

    public static final UserExistException EXCEPTION = new UserExistException();

    private UserExistException(){
        super(UserError.USER_EXIST);
    }

}
