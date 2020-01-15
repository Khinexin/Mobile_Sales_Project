package com.demo.mobileproject.config;

import java.lang.annotation.*;

@Target({ ElementType.PARAMETER, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@AuthenticationPrincipal
public @interface CurrentUser {
}
