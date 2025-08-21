package com.aja.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	@NotBlank(message = "Product name is mandatory")
	@Size(min = 2, max = 15, message = "Product name must be between 2 and 15 characters")
	private String productName;

	@NotBlank(message = "Category is mandatory")
	@Size(min = 2, max = 15, message = "Category must be between 2 and 15 characters")
	private String category;

	@NotNull(message = "Quantity is mandatory")
	@Min(value = 1, message = "Quantity must be one or more")
	private Integer quantity;

	@NotNull(message = "Price is mandatory")
	@DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
	private Double price;

	@NotBlank(message = "Availability is mandatory")
	@Pattern(regexp = "In Stock|Out of Stock|Preorder", message = "Availability must be 'In Stock', 'Out of Stock', or 'Preorder'")
	private String availability;

}
