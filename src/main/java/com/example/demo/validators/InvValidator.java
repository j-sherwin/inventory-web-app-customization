package com.example.demo.validators;

import com.example.demo.domain.Part;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InvValidator implements ConstraintValidator<ValidInv,Part> {


    @Override
    public void initialize(ValidInv constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        //return (part.getInv() <= part.getMaxInv()) && (part.getInv() >= part.getMinInv());
        int partInv = part.getInv();
        int invMax = part.getMaxInv();
        int invMin = part.getMinInv();

        if (partInv > invMax) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("Inventory must be below the Max Inventory amount")
                    .addConstraintViolation();
            return false;
        }
        else if (partInv < invMin) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("Inventory must be above the Minimum Inventory amount")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}