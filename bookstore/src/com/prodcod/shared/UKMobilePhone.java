package com.prodcod.shared;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UKMobilePhoneValidator.class)
@Documented
public @interface  UKMobilePhone  {
        
        String message() default "You must supply a UK mobile phone number";
        
        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
}

