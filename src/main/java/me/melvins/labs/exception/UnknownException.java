/*
 *
 */

package me.melvins.labs.exception;

import me.melvins.labs.exception.handling.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author Mels
 */
public class UnknownException extends RuntimeException {

    private HttpStatus httpStatus;

    private ErrorCode errorCode;

    public UnknownException(HttpStatus httpStatus, ErrorCode errorCode) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
