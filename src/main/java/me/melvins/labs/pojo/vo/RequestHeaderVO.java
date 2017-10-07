/*
 *
 */

package me.melvins.labs.pojo.vo;

import javax.validation.constraints.NotEmpty;

/**
 * @author Mels
 */
public class RequestHeaderVO {

    @NotEmpty(message = "EC221")
    private String correlationId;

    @NotEmpty(message = "EC222")
    private String requesterId;

    @NotEmpty(message = "EC223")
    private String businessContext;

    private String version;

    /**
     * Default Constructor.
     */
    public RequestHeaderVO() {
    }

    /**
     * Getter for {@code orrelationId}.
     *
     * @return
     */
    public String getCorrelationId() {
        return correlationId;
    }

    /**
     * Setter for {@code correlationId}.
     *
     * @param correlationId
     */
    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    /**
     * Getter for {@code version}.
     *
     * @return
     */
    public String getVersion() {
        return version;
    }

    /**
     * Setter for {@code version}.
     *
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }

}
