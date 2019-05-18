package com.demo.mobileproject.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ResourceNotFoundException extends Exception {

    protected final Log logger = LogFactory.getLog(this.getClass());

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public ResourceNotFoundException(String arg0) {
        super(arg0);
    }

    public ResourceNotFoundException(Throwable arg0) {
        super(arg0);
    }


}
