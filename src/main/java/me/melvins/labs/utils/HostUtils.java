/*
 *
 */

package me.melvins.labs.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Host Utility Functions.
 *
 * @author Mels
 */
public final class HostUtils {

    /**
     * Privatized Default Constructor To Avoid Object Instantiation.
     */
    private HostUtils() {
    }

    public static String getHostIp() {

        try {
            return InetAddress.getLocalHost().getHostAddress();

        } catch (UnknownHostException e) {
            e.printStackTrace(); // TODO
        }

        return null;
    }

}
