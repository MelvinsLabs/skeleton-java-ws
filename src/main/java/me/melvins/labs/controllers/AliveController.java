/*
 * 
 */

package me.melvins.labs.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFormatMessageFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MelvinMathai
 */
@RestController
@RequestMapping(value = "Alive")
public class AliveController {

    private static final Logger LOGGER = LogManager.getLogger(AliveController.class,
            new MessageFormatMessageFactory());

    @RequestMapping(value = "Check", method = RequestMethod.GET)
    public List<String> check() {

        LOGGER.info("Is Alive");

        List<String> strings = new ArrayList<String>();
        strings.add("Is");
        strings.add("Alive");

        return strings;
    }

}
