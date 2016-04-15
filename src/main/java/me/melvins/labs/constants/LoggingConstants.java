/*
 *
 */

package me.melvins.labs.constants;

/**
 * @author Mels
 */
public enum LoggingConstants {

    /**
     * CorrelationID
     */
    CID("CorrelationID");

    /**
     * Constructor
     *
     * @param description
     */
    LoggingConstants(String description) {
        this.description = description;
    }

    private String description;

    /**
     * Getter of {@code description}.
     *
     * @return Description of the Code.
     */
    public String getDescription() {
        return description;
    }

}
