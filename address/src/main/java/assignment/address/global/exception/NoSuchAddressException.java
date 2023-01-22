package assignment.address.global.exception;

import assignment.address.global.code.ErrorCode;

public class NoSuchAddressException extends RestApiException {

    public NoSuchAddressException(ErrorCode errorCode) {
        super(errorCode);
    }
}
