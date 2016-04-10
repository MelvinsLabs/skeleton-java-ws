/*
 * 
 */

package me.melvins.labs.controller;

import me.melvins.labs.capability.Capability;
import me.melvins.labs.exception.KnownException;
import me.melvins.labs.exception.RequestHeaderValidationException;
import me.melvins.labs.exception.UnknownException;
import me.melvins.labs.exception.handling.ErrorCode;
import me.melvins.labs.pojo.models.DomainModel;
import me.melvins.labs.pojo.vo.RequestHeaderVO;
import me.melvins.labs.pojo.vo.ResponseVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFormatMessageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static me.melvins.labs.utils.HeaderUtils.transformRequestHeader;
import static me.melvins.labs.utils.HeaderUtils.validateRequestHeader;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @author Mels
 */
@RestController
@RequestMapping(value = "Alive")
public class AliveController {

    @Autowired
    private Capability capabilityImpl;

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

            capabilityImpl.process();

            // TODO transform Response Headers.

        } catch (Exception ex) {
            handleExceptions(ex);
        }

        return new ResponseEntity<>(responseVO, null, HttpStatus.OK);
    }

    @RequestMapping(value = "Test", method = RequestMethod.POST)
    public ResponseEntity<ResponseVO> testPost(@RequestHeader Map<String, String> headers,
                                               @RequestBody DomainModel domainModel) {

        ResponseVO responseVO = null;
        try {
            LOGGER.info("Is Alive");

            List<String> strings = new ArrayList<>();
            strings.add("Is");
            strings.add("Alive");

            LOGGER.debug("Request Body : {0}", domainModel);
            domainModel.getIdentifiers().forEach((k, v) -> {
                strings.add(k + " : " + v);
            });

            responseVO = new ResponseVO();
            responseVO.setStringList(strings);

        } catch (Exception ex) {
            handleExceptions(ex);
        }

        return new ResponseEntity<>(responseVO, null, HttpStatus.OK);
    }

    private void handleExceptions(Exception ex) {

        if (ex instanceof RequestHeaderValidationException) {
            throw (RequestHeaderValidationException) ex;

        } else if (ex instanceof KnownException) {
            throw (KnownException) ex;

        } else {
            ErrorCode errorCode = ErrorCode.EC1000;
            LOGGER.error(errorCode.toString(), ex);
            throw new UnknownException(INTERNAL_SERVER_ERROR, errorCode, ex);
        }
    }

}
