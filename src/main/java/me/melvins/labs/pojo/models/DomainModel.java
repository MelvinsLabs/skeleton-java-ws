/*
 *
 */

package me.melvins.labs.pojo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * DomainModel
 *
 * @author Mels
 */
public class DomainModel {

    @JsonProperty(value = "Identifiers")
    private Map<String, String> identifiers;

    public DomainModel() {
        identifiers = new HashMap<>();
    }

    public Map<String, String> getIdentifiers() {
        return identifiers;
    }

    /**
     * Overriding {@code toString} implementation.
     *
     * @return
     */
    @Override
    public String toString() {
        return "DomainModel{" +
                "identifiers=" + identifiers +
                '}';
    }

}
