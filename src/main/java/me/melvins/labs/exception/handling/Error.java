/*
 *
 */

package me.melvins.labs.exception.handling;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Error Response Model.
 *
 * @author Mels
 */
public class Error {

    @JsonProperty(value = "ErrorCode")
    private String errorCode;

    @JsonProperty(value = "ErrorMessage")
    private String errorMessage;

    /**
     * Constructor
     *
     * @param errorCode
     * @param errorMessage
     */
    public Error(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * Getter for {@code errorCode}.
     *
     * @return
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Getter for {@code errorMessage}.
     *
     * @return
     */
    public String getErrorMessage() {
        return errorMessage;
    }

}
