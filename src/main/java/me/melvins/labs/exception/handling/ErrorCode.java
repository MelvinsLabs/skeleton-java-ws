/*
 *
 */

package me.melvins.labs.exception.handling;

/**
 * <p>
 * Each ErrorCode should be referenced only from a Single Catch block.
 * </p>
 * <p>
 * The Default ErrorCodes naming strategy.
 * <ul>
 * <li>ALL0xx - Reserved</li>
 * <li>ALL1xx - Exception Handling Errors</li>
 * <li>ALL2xx - Validation Errors</li>
 * <li>ALL3xx - Application Errors</li>
 * <li>ALL4xx - External Dependency Errors</li>
 * <li>ALL9xx - Utils Errors</li>
 * </ul>
 * <br>
 * <i>ALL<b>xyz</b></i> <br>
 * - <b>x</b> denotes each Classification of Errors. <br>
 * - <b>y</b> denotes each Group of Errors. <br>
 * - <b>z</b> denotes each Source of Errors. <br>
 * </p>
 *
 * @author Mels
 */
public enum ErrorCode {

    /**
     *
     */
    EC211("{0} Validation Errors In Request Header"),
    /**
     *
     */
    EC221("Invalid Correlation Id {0}"),
    /**
     *
     */
    EC222("Invalid Requester Id {0}"),
    /**
     *
     */
    EC223("Invalid Business Context {0}"),
    /**
     *
     */
    EC231("Unable To Transform Request Headers {0}"),
    /**
     *
     */
    EC311("Unknown Exception"),
    /**
     *
     */
    EC321("Unexpected Exception While Parsing {0} To {1}"),
    /**
     *
     */
    EC322("Unexpected Exception While Accessing DataStore"),
    /**
     *
     */
    EC911("UnknownHostException - {0}");

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
