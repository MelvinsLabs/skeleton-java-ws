/*
 * 
 */

package me.melvins.labs.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import me.melvins.labs.capability.Capability;
import me.melvins.labs.exception.KnownException;
import me.melvins.labs.exception.RequestHeaderValidationException;
import me.melvins.labs.exception.UnknownException;
import me.melvins.labs.exception.handling.Error;
import me.melvins.labs.exception.handling.ErrorCode;
import me.melvins.labs.pojo.models.DomainModel;
import me.melvins.labs.pojo.vo.RequestHeaderVO;
import me.melvins.labs.pojo.vo.ResponseVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFormatMessageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static me.melvins.labs.constants.ControllerConstants.*;
import static me.melvins.labs.exception.handling.ErrorCode.EC311;
import static me.melvins.labs.utils.HeaderUtils.createResponseHeaders;
import static me.melvins.labs.utils.HeaderUtils.transformRequestHeader;
import static me.melvins.labs.utils.HeaderUtils.validateRequestHeader;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Alive Controller
 *
 * @author Mels
 */
@RestController
@RequestMapping(value = "Alive")
public class AliveController {

    @Autowired
    private Environment env;

    @Autowired
    private Capability capabilityImpl;

    private static final Logger LOGGER =
            LogManager.getLogger(AliveController.class, new MessageFormatMessageFactory());

    @ApiImplicitParams({
            @ApiImplicitParam(name = _CID, value = _CIDDescription,
                    required = true, dataType = STRING, paramType = HEADER),
            @ApiImplicitParam(name = _RID, value = _RIDDescription,
                    required = true, dataType = STRING, paramType = HEADER),
            @ApiImplicitParam(name = _BC, value = _BCDescription,
                    required = true, dataType = STRING, paramType = HEADER),
            @ApiImplicitParam(name = _CT, value = _CTDescription, allowableValues = V1,
                    required = true, dataType = STRING, paramType = HEADER)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful Scenario", response = ResponseVO.class),
            @ApiResponse(code = 400, message = "INTERNAL_SERVER_ERROR", response = Error.class)
    })
    @RequestMapping(value = "Test", method = GET, consumes = {V1}, produces = {V1})
    public ResponseEntity<ResponseVO> testGet(@ApiIgnore
                                              @RequestHeader Map<String, Object> headers,
                                              @ApiParam(name = "check", type = STRING, required = true)
                                              @RequestParam(name = "check") String checker) {

        LOGGER.debug("Testing Alive {0} {1}", checker, env.getProperty("ws.env"));

        ResponseVO responseVO = null;
        try {
            RequestHeaderVO requestHeaderVO = transformRequestHeader(headers);

            validateRequestHeader(requestHeaderVO);

            List<String> strings = new ArrayList<>();
            strings.add("Is");
            strings.add("Alive");
            strings.add("With");
            strings.add(checker);

            responseVO = new ResponseVO();
            responseVO.setStringList(strings);

            //capabilityImpl.process();

        } catch (Exception ex) {
            handleExceptions(ex);
        }

        return new ResponseEntity<>(responseVO, createResponseHeaders(), OK);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = _CID, value = _CIDDescription,
                    required = true, dataType = STRING, paramType = HEADER),
            @ApiImplicitParam(name = _RID, value = _RIDDescription,
                    required = true, dataType = STRING, paramType = HEADER),
            @ApiImplicitParam(name = _BC, value = _BCDescription,
                    required = true, dataType = STRING, paramType = HEADER),
            @ApiImplicitParam(name = _CT, value = _CTDescription,
                    allowableValues = V1,
                    required = true, dataType = STRING, paramType = HEADER)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful Scenario", response = ResponseVO.class),
            @ApiResponse(code = 400, message = "INTERNAL_SERVER_ERROR", response = Error.class)
    })
    @RequestMapping(value = "Test", method = POST, consumes = {V1}, produces = {V1})
    public ResponseEntity<ResponseVO> testPost(@ApiIgnore
                                               @RequestHeader Map<String, Object> headers,
                                               @RequestBody DomainModel domainModel) {

        LOGGER.info("Is Alive");

        ResponseVO responseVO = null;
        try {

            RequestHeaderVO requestHeaderVO = transformRequestHeader(headers);

            validateRequestHeader(requestHeaderVO);

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

        return new ResponseEntity<>(responseVO, createResponseHeaders(), OK);
    }

    /**
     * Generic method to handle Exception from the Controller Operations.
     *
     * @param ex Exception to handle.
     */
    private void handleExceptions(Exception ex) {

        if (ex instanceof RequestHeaderValidationException) {
            throw (RequestHeaderValidationException) ex;

        } else if (ex instanceof KnownException) {
            throw (KnownException) ex;

        } else {
            ErrorCode errorCode = EC311;
            LOGGER.error(errorCode.toString(), ex);
            throw new UnknownException(INTERNAL_SERVER_ERROR, errorCode, ex);
        }
    }

}
