/*
 *
 */

package me.melvins.labs.constants;

/**
 * @author Mels
 */
public enum LoggingConstants {

    /**
     * CorrelationId
     */
    CID("CorrelationId"),
    /**
     * RequesterId
     */
    RID("RequesterId");

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
