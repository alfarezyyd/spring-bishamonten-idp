package alfarezyyd.bishamonten.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ValidationUtil {
  private final Validator validator;

  public ValidationUtil(Validator validator) {
    this.validator = validator;
  }

  public void validateRequestObject(Object requestObject) {
    Set<ConstraintViolation<Object>> constraintViolations = validator.validate(requestObject);
    if (!constraintViolations.isEmpty()) {
      throw new ConstraintViolationException(constraintViolations);
    }
  }
}
