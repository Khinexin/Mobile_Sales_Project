package com.demo.mobileproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.ServletContextInitializer;

import javax.annotation.ManagedBean;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@ManagedBean
public class ExecutorListener implements ServletContextInitializer {

    private static final Logger LOGGER = LogManager.getLogger(ExecutorListener.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        LOGGER.info(" ===== application === servlet === start === ");
    }

}