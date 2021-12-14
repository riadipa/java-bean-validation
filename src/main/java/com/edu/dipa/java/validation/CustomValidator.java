package com.edu.dipa.java.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class CustomValidator<T> {

    private final T target;

    protected CustomValidator(T target) {
        this.target = target;
    }

    public T getTarget() {
        return target;
    }

    public void validate() {
        Validator validator = getValidator();

        Set<ConstraintViolation<CustomValidator<T>>> violations = validator.validate(this);

        if (!violations.isEmpty()) {
            List<String> violationMessages = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            String errorMessage = String.join(",", violationMessages);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private Validator getValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }
}
