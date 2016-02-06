/*
 *
 */

package me.melvins.labs.exception.handling;

/**
 * @author Mels
 */
public class Error {

    private String errorCode;

    private String errorMessage;

    public Error(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
