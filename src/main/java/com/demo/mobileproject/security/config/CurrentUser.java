package com.demo.mobileproject.security.config;

import java.lang.annotation.*;

@Target({ ElementType.PARAMETER, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@AuthenticationPrincipal
public @interface CurrentUser {
}
