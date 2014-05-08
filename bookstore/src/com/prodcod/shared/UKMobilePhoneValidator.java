package com.prodcod.shared;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Custom validator to test if mobile phone number is UK based.
 * @author BruceWayne
 *
 */
public class UKMobilePhoneValidator implements ConstraintValidator<UKMobilePhone, String> {

	//List of valid UK prefixes
	private final String[] VALID_PREFIXES = new String[] {"071", "074", "075"," 077","078", "079"};

	@Override
    public void initialize(UKMobilePhone constraintAnnotation) {}
    
    @Override
    public boolean isValid(final String number, ConstraintValidatorContext context) {
            
            if( number == null ) {
                return true;            	
            }

            if(number.length() != 11) {
            	return false;
            }
            
            for (String prefix : VALID_PREFIXES) {
            	if(number.startsWith(prefix)) {
            		return true;
            	}
            }
            
            return false;
    }
}