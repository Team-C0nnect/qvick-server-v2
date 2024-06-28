package qvick.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import qvick.exception.error.ErrorProperty;

@Getter
@RequiredArgsConstructor
public class BusinessException extends RuntimeException {

    private final ErrorProperty error;

}
