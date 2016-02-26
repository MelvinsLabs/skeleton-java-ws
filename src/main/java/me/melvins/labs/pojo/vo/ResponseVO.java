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

    public ResponseVO() {
        date = new Date();
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
