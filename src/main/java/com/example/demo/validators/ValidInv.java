package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = {InvValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidInv {
    String message() default "Inventory must be between Minimum and Maximum Inventory Values!";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

}
