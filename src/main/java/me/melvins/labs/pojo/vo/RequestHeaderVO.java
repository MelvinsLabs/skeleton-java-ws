/*
 *
 */

package me.melvins.labs.pojo.vo;

/**
 * @author Mels
 */
public class RequestHeaderVO {

    private String correlationId;

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
