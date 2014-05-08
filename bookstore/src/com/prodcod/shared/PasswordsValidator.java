package com.prodcod.shared;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsValidator implements ConstraintValidator<PasswordValidatorAnnotation, User> {

    @Override
    public void initialize(PasswordValidatorAnnotation constraintAnnotation) {}
    
    @Override
    public boolean isValid(User customer, ConstraintValidatorContext context) {
            
            if( customer == null )
                    return true;
            
            String password = customer.getPassword();
            String confirmPassword = customer.getConfirmPassword();
            
            if( password == null && confirmPassword == null )
                    return true;
            
            if( password != null && password.equals(confirmPassword) )
                    return true;
            
            return false;
    }
}