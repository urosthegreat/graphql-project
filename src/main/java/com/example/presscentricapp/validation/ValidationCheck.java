package com.example.presscentricapp.validation;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class ValidationCheck {
    public boolean isIntegerParamValid(Integer param) {
        return param != null && param > 0;
    }
}
