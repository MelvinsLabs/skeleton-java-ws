/*
 *
 */

package me.melvins.labs.constants;

/**
 * @author Mels
 */
public enum LoggingConstants {

    CID("CorrelationID");

    LoggingConstants(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

}
