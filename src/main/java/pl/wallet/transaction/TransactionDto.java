package pl.wallet.transaction;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import pl.wallet.category.CategoryDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@ToString
public class TransactionDto {

  @Null(message = "New transaction can not have id")
  private Long id;

  @NotNull(message = "Transaction must have name")
  private String name;

  private String description;

  @Null
  //  TODO transaction should hove category
  private CategoryDto category;

  //  create annotation to BigDeciaml
  //  @Min(value = 1, message = "Transaction should have price")
  private BigDecimal price;

  private LocalDateTime addingTime;

  @Builder
  public TransactionDto (@Null(message = "New transaction can not have id") Long id,
                         @NotNull(message = "Transaction should have name") String name,
                         String description,
                         CategoryDto category,
//                         @Min(value = 1, message = "Transaction should have price")
                         BigDecimal price, LocalDateTime addingTime) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.category = category;
    this.price = price;
    this.addingTime = addingTime;
  }
}
