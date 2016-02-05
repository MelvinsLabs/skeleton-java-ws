/*
 *
 */

package me.melvins.labs.utils;

import me.melvins.labs.exception.RequestHeaderValidationException;
import me.melvins.labs.vo.RequestHeaderVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFormatMessageFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Map;
import java.util.Set;

import static me.melvins.labs.utils.BeanUtils.fillBean;

/**
 * @author Mels
 */
public class HeaderUtils {

    private static final Logger LOGGER = LogManager.getLogger(HeaderUtils.class,
            new MessageFormatMessageFactory());

    public static RequestHeaderVO transformRequestHeader(Map<String, Object> headers, Class clazz) {

        RequestHeaderVO requestHeaderVO = null;
        try {
            requestHeaderVO = (RequestHeaderVO) fillBean(headers, clazz);

        } catch (InstantiationException | IllegalAccessException ex) {
            LOGGER.error("Unable To Transform Request Headers");
            // TODO
        }

        return requestHeaderVO;
    }

    public static void validateRequestHeader(RequestHeaderVO requestHeaderVO) {

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        javax.validation.Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<RequestHeaderVO>> constraintViolations = validator.validate(requestHeaderVO);

        if (constraintViolations.toArray().length != 0) {
            String message = "Validation Errors In Request Header";
            throw new RequestHeaderValidationException(message, constraintViolations);
        }
    }

}
