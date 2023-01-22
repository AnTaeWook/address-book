package assignment.address.global.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {

    NO_SUCH_ADDRESS(HttpStatus.NOT_FOUND, "No Such Address For That AddressID")
    ;

    private final HttpStatus status;
    private final String message;
}
