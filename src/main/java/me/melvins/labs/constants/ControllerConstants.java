/*
 *
 */

package me.melvins.labs.constants;

/**
 * @author Mels
 */
public final class ControllerConstants {

    /**
     * Private Default Constructor To Avoid Object Instantiation.
     */
    private ControllerConstants() {
    }

    /*
     * Header Constants
     */

    public static final String _CID = "CorrelationId";

    public static final String _CIDDescription = "Unique Correlation Id For Each Request";

    public static final String _RID = "RequesterId";

    public static final String _RIDDescription = "Unique Requester Id Assigned To Each API Consumer";

    public static final String _BC = "BusinessContext";

    public static final String _BCDescription = "Business Context / Requester's Requester Id";

    public static final String _CT = "Content-Type";

    public static final String _CTDescription = "Content Type With API Endpoint Version";

    /*
     * Content-Type & API Versions
     */

    public static final String V1 = "application/vnd.v1+json";

    /*
     * API Doc Repeating Words
     */

    public static final String STRING = "String";

    public static final String HEADER = "Header";

}
