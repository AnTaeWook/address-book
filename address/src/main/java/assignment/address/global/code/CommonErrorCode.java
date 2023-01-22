package assignment.address.global.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode {

    WRONG_PARAMETER(HttpStatus.BAD_REQUEST, "Wrong Parameter For Address")
    ;

    private final HttpStatus status;
    private final String message;
}
