package qvick.exception;

import qvick.exception.error.ErrorCode;

public class BadRequestException extends BusinessException {
    
    public static final BadRequestException EXCEPTION = new BadRequestException();
    
    private BadRequestException(){
        super(ErrorCode.BAD_REQUEST);
    }

}
