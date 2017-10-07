/*
 *
 */

package me.melvins.labs.exception.handling;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Error Response Model.
 *
 * @author Mels
 */
@ApiModel//(value = "Error", reference = "Error")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Error {

    @JsonProperty(value = "ErrorCode")
    private String errorCode;

    @JsonProperty(value = "ErrorMessage")
    private String errorMessage;

    @JsonProperty(value = "ErrorList")
    private List<String> errorList;

    /**
     * Constructor
     *
     * @param errorCode
     * @param errorMessage
     */
    public Error(String errorCode,
                 String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * Constructor
     *
     * @param errorCode
     * @param errorMessage
     */
    public Error(String errorCode,
                 String errorMessage,
                 List<String> errorList) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorList = errorList;
    }

    @Override
    public String toString() {
        return "Error{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorList=" + errorList +
                '}';
    }

}
