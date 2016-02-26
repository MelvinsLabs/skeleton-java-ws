/*
 *
 */

package me.melvins.labs.exception.handling;

/**
 * @author Mels
 */
public enum ErrorCode {

    EC1000("Unknown Exception"),
    EC1001("Unexpected Exception While Parsing {0} To {1}"),
    EC1002("Unexpected Exception While Accessing DataStore");

    ErrorCode(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return this.name() + " " + this.getMessage();
    }
}
