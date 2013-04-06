package com.github.omerucel.jcosmos;

import com.github.omerucel.jcosmos.error.ValidationError;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import org.apache.commons.beanutils.BeanUtils;

public class Validator<T> extends ErrorManager{
    private static javax.validation.Validator validator;

    public static class Form{
        private String toCamelCase(String text)
        {
            String[] parts = text.split("_");
            String camelCaseString = null;
            for (String part : parts){
                if (camelCaseString == null)
                {
                    camelCaseString = part;
                    continue;
                }

                camelCaseString = camelCaseString + toProperCase(part);
            }
            return camelCaseString;
        }

        private String toProperCase(String s) {
            return s.substring(0, 1).toUpperCase() +
                       s.substring(1).toLowerCase();
        }

        public void bind(HashMap<Object, Object> data)
        {
            for(Map.Entry<Object, Object> entry : data.entrySet())
            {
                String key = toCamelCase((String) entry.getKey());
                try {
                    BeanUtils.setProperty(this, key, entry.getValue());
                } catch (Exception ex) {
                    continue;
                }
            }
        }

        public void validate()
        {
            
        }
    }

    private void validate(T object)
    {
        Set<ConstraintViolation<T>> constraintViolations
                = getValidator().validate(object);

        if (!constraintViolations.isEmpty())
        {
            for(ConstraintViolation<T> violations : constraintViolations)
            {
                String fieldName = (String) violations.getInvalidValue();
                String errorType = violations.getConstraintDescriptor()
                        .getAnnotation().annotationType().getSimpleName();

                addError(new ValidationError(
                        fieldName, 
                        errorType, 
                        violations.getMessage()));
            }
        }
    }

    public final Boolean isValid(T object) {
        validate(object);
        ((Form)object).validate();
        return !hasError();
    }

    private javax.validation.Validator getValidator()
    {
        if (validator == null)
            validator = Validation.buildDefaultValidatorFactory().getValidator();

        return validator;
    }
}
