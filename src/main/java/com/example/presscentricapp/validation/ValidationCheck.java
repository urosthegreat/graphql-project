/**
 * This class provides validation checks for various input parameters in the PressCentric application.
 */
package com.example.presscentricapp.validation;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * A validation utility class that checks the validity of various input parameters.
 */
@NoArgsConstructor
@Component
public class ValidationCheck {

    /**
     * Checks the validity of an integer parameter.
     *
     * @param param The integer parameter to validate.
     * @return {@code true} if the parameter is not null and greater than 0, {@code false} otherwise.
     */
    public boolean isIntegerParamValid(Integer param) {
        return param != null && param > 0;
    }
}
