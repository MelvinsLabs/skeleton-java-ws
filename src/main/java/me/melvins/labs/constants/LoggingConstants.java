/*
 *
 */

package me.melvins.labs.constants;

import static me.melvins.labs.constants.ControllerConstants._BC;
import static me.melvins.labs.constants.ControllerConstants._CID;
import static me.melvins.labs.constants.ControllerConstants._RID;

/**
 * @author Mels
 */
public enum LoggingConstants {

    /**
     * CorrelationId
     */
    CID(_CID),
    /**
     * RequesterId
     */
    RID(_RID);

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
