/*
 *
 */

package me.melvins.labs.capability;

import me.melvins.labs.exception.KnownException;
import me.melvins.labs.exception.handling.ErrorCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFormatMessageFactory;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.ParseException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @author Mels
 */
@Component
public class CapabilityImpl implements Capability {

    private static final Logger LOGGER = LogManager.getLogger(CapabilityImpl.class,
            new MessageFormatMessageFactory());

    @Override
    public void process() {

        try {
            execute();
            throw new ParseException("", 0);

        } catch (ParseException ex) {
            ErrorCode errorCode = ErrorCode.EC321;
            LOGGER.error(errorCode.toString(), "{data}", Class.class.getName(), ex);
            String displayMessage = MessageFormat.format(errorCode.getMessage(), "", Class.class.getSimpleName());
            throw new KnownException(INTERNAL_SERVER_ERROR, errorCode, displayMessage, ex);
        }
    }

    public void execute() {

        try {
            throw new SQLException();

        } catch (SQLException ex) {
            ErrorCode errorCode = ErrorCode.EC322;
            LOGGER.error(errorCode.toString(), ex);
            String displayMessage = errorCode.getMessage();
            throw new KnownException(INTERNAL_SERVER_ERROR, errorCode, displayMessage, ex);
        }
    }
}
