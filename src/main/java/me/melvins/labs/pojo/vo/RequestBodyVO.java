/*
 *
 */

package me.melvins.labs.pojo.vo;

/**
 * @author Mels
 */
public class RequestBodyVO {

    private String name;

    private String email;

    /**
     * Default Constructor.
     */
    public RequestBodyVO() {
    }

    /**
     * Getter for {@code name}.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for {@code name}.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for {@code email}.
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for {@code email}.
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
