package com.prodcod.shared;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordsValidator.class)
@Documented
public @interface PasswordValidatorAnnotation {
        
        String message() default "Passwords must be the same";
        
        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
}

