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
@Constraint(validatedBy = MatrixValidator.class)
@Documented
public @interface ValidMatrix {

    String message() default "Invalid matrix";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
