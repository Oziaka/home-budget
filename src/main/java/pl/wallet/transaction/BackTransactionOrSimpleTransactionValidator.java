package pl.wallet.transaction;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.wallet.category.Category;
import pl.wallet.category.CategoryService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@Component
@AllArgsConstructor
@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class BackTransactionOrSimpleTransactionValidator implements ConstraintValidator<BackTransactionOrSimpleTransaction, Object[]> {
  private CategoryService categoryService;

  public void initialize (BackTransactionOrSimpleTransaction backTransactionOrSimpleTransaction) {
    backTransactionOrSimpleTransaction.message();
  }

  public boolean isValid (Object[] objs, ConstraintValidatorContext context) {
    Category category = categoryService.getCategory((Long) objs[1]);
    return (category.getTransactionType().ordinal() == 4 || category.getTransactionType().ordinal() == 5) == (((TransactionDto) objs[3]).getTransactionIdReference() != null);
  }
}
