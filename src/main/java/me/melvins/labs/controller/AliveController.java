/*
 * 
 */

package me.melvins.labs.controller;

import me.melvins.labs.exception.RequestHeaderValidationException;
import me.melvins.labs.exception.UnknownException;
import me.melvins.labs.exception.handling.ErrorCode;
import me.melvins.labs.vo.RequestHeaderVO;
import me.melvins.labs.vo.ResponseVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFormatMessageFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static me.melvins.labs.utils.HeaderUtils.transformRequestHeader;
import static me.melvins.labs.utils.HeaderUtils.validateRequestHeader;

/**
 * @author Mels
 */
@RestController
@RequestMapping(value = "Alive")
public class AliveController {

    private static final Logger LOGGER = LogManager.getLogger(AliveController.class,
            new MessageFormatMessageFactory());

    @RequestMapping(value = "Test", method = RequestMethod.GET)
    public ResponseEntity<ResponseVO> testGet(@RequestHeader Map<String, Object> headers,
                                              @RequestParam(name = "check") String checker) {
        LOGGER.debug("Testing Alive");

        ResponseVO responseVO = null;
        try {
            RequestHeaderVO requestHeaderVO = transformRequestHeader(headers, RequestHeaderVO.class);

            validateRequestHeader(requestHeaderVO);

            List<String> strings = new ArrayList<>();
            strings.add("Is");
            strings.add("Alive");
            strings.add("With");
            strings.add(checker);

            responseVO = new ResponseVO();
            responseVO.setStringList(strings);

            // TODO transform Response Headers.

        } catch (Exception ex) {
            handleExceptions(ex);
        }

        return new ResponseEntity<>(responseVO, null, HttpStatus.OK);
    }

    @RequestMapping(value = "Test", method = RequestMethod.POST) // TODO
    public ResponseEntity<ResponseVO> testPost(@RequestHeader Map<String, String> headers, String checker) {

        LOGGER.info("Is Alive");

        List<String> strings = new ArrayList<>();
        strings.add("Is");
        strings.add("Alive");
        strings.add(checker);

        ResponseVO responseVO = new ResponseVO();
        responseVO.setStringList(strings);

        return new ResponseEntity<>(responseVO, null, HttpStatus.OK);
    }

    private void handleExceptions(Exception ex) {

        if (ex instanceof RequestHeaderValidationException) {
            throw (RequestHeaderValidationException) ex;

        } else {
            LOGGER.error("Unknown Exception Detected", ex);
            throw new UnknownException(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.EC1000);
        }
    }

}
