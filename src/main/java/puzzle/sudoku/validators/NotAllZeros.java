package puzzle.sudoku.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = NotAllZerosValidator.class)
@Documented
public @interface NotAllZeros {

    String message() default "All numbers are zeros, please fill some cells with numbers [1, 9]";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
