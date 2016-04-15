/*
 *
 */

package me.melvins.labs.exception.handling;

/**
 * All the Error Codes for Exception Handing.
 *
 * @author Mels
 */
public enum ErrorCode {

    /**
     *
     */
    EC1000("Unknown Exception"),

    /**
     *
     */
    EC1001("Unexpected Exception While Parsing {0} To {1}"),

    /**
     *
     */
    EC1002("Unexpected Exception While Accessing DataStore");

    private String message;

    /**
     * Constructor
     *
     * @param message
     */
    ErrorCode(String message) {
        this.message = message;
    }

    /**
     * Getter for {@code message}.
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * Overriding the {@code toString}
     *
     * @return
     */
    @Override
    public String toString() {
        return this.name() + " " + this.getMessage();
    }

}
