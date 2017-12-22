/*
 *
 */

package me.melvins.labs.utils;

import me.melvins.labs.exception.RequestHeaderValidationException;
import me.melvins.labs.pojo.vo.RequestHeaderVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFormatMessageFactory;
import org.springframework.http.HttpHeaders;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Map;
import java.util.Set;

import static java.lang.String.valueOf;
import static java.lang.System.currentTimeMillis;
import static java.text.MessageFormat.format;
import static me.melvins.labs.exception.handling.ErrorCode.EC211;
import static me.melvins.labs.exception.handling.ErrorCode.EC231;
import static me.melvins.labs.utils.BeanUtils.fillBean;

/**
 * Request Header Utility functions.
 *
 * @author Mels
 */
public final class HeaderUtils {

    private static final Logger LOGGER =
            LogManager.getLogger(HeaderUtils.class, new MessageFormatMessageFactory());

    /**
     * Privatized Default Constructor To Avoid Object Instantiation.
     */
    private HeaderUtils() {
    }

    /**
     * Transform the Request Headers as Map, into {@link RequestHeaderVO}.
     *
     * @param headers Map of Headers as Key-Value pair.
     * @return
     */
    public static RequestHeaderVO transformRequestHeader(Map<String, Object> headers) {

        RequestHeaderVO requestHeaderVO = null;
        try {
            requestHeaderVO = (RequestHeaderVO) fillBean(headers, RequestHeaderVO.class);

        } catch (InstantiationException | IllegalAccessException ex) {
            String errorMessage = format(EC231.toString(), headers);
            LOGGER.error(errorMessage);
            // TODO
        }

        return requestHeaderVO;
    }

    /**
     * Validate the {@link RequestHeaderVO}.
     *
     * @param requestHeaderVO Request Header POJO
     */
    public static void validateRequestHeader(RequestHeaderVO requestHeaderVO) {

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        javax.validation.Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<RequestHeaderVO>> constraintViolations = validator.validate(requestHeaderVO);

        int violationCount = constraintViolations.toArray().length;

        if (violationCount != 0) {
            String errorMessage = format(EC211.toString(), violationCount);
            LOGGER.error(errorMessage);
            throw new RequestHeaderValidationException(errorMessage, constraintViolations);
        }
    }

    public static HttpHeaders createResponseHeaders() {

        String hostIp = HostUtils.getHostIp();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("ResponseHost", hostIp);
        httpHeaders.set("ResponseTimeStamp", valueOf(currentTimeMillis()));

        return httpHeaders;

    }

}
