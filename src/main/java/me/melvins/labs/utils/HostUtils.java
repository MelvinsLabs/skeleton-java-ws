/*
 *
 */

package me.melvins.labs.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFormatMessageFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.MessageFormat;

import static me.melvins.labs.exception.handling.ErrorCode.EC911;

/**
 * Host Utility Functions.
 *
 * @author Mels
 */
public final class HostUtils {

    private static final Logger LOGGER =
            LogManager.getLogger(HostUtils.class, new MessageFormatMessageFactory());

    /**
     * Privatized Default Constructor To Avoid Object Instantiation.
     */
    private HostUtils() {
    }

    public static String getHostIp() {

        try {
            return InetAddress.getLocalHost().getHostAddress();

        } catch (UnknownHostException ex) {
            String errorMessage = MessageFormat.format(EC911.toString(), ex.getMessage());
            LOGGER.error(errorMessage, ex);
        }

        return null;
    }

}
