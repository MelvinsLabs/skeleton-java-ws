/*
 *
 */

package me.melvins.labs.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 * @author Mels
 */
public class ResponseVO {

    @JsonProperty(value = "Strings", index = 1)
    private List<String> stringList;

    @JsonProperty(value = "Now", index = 2)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    /**
     * Default Constructor
     */
    public ResponseVO() {
        date = new Date();
    }

    /**
     * Getter for {@code stringList}.
     *
     * @return
     */
    public List<String> getStringList() {
        return stringList;
    }

    /**
     * Setter for {@code stringList}.
     *
     * @param stringList
     */
    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    /**
     * Getter for {@code date}.
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter for {@code date}.
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

}
