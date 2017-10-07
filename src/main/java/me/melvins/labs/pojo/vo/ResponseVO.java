/*
 *
 */

package me.melvins.labs.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 * @author Mels
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
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
     * Setter for {@code stringList}.
     *
     * @param stringList
     */
    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public String toString() {
        return "ResponseVO{" +
                "stringList=" + stringList +
                ", date=" + date +
                '}';
    }

}
