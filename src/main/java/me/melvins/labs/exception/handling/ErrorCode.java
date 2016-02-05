/*
 *
 */

package me.melvins.labs.exception.handling;

/**
 * @author Mels
 */
public enum ErrorCode {

    EC1000("Unknown Exception");

    ErrorCode(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

}
