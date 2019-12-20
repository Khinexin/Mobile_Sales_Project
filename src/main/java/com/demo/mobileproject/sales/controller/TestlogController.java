package com.demo.mobileproject.sales.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestlogController {

    private static final Logger LOGGER = LogManager.getLogger(TestlogController.class);

    @GetMapping("/test-log")
    @ResponseBody
    public String testMethod() {
        LOGGER.trace("This is a trace log example");
        LOGGER.info("This is an info log example");
        LOGGER.debug("This is a debug log example");
        LOGGER.error("This is an error log example");
        LOGGER.fatal("This is a fatal log example");
        LOGGER.warn("This is a warn log example");

        return "Check the Console Logs";
    }

}
