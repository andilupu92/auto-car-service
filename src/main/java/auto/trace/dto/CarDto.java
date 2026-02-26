package auto.trace.dto;

import auto.trace.annotation.MaxCurrentYear;
import jakarta.validation.constraints.*;

public record CarDto(@NotBlank(message = "Brand is required")
                     @Size(min = 2, max = 50, message = "Brand must be between 2 and 50 characters")
                     String brand,

                     @NotBlank(message = "Model is required")
                     @Size(min = 1, max = 50, message = "Model must be between 1 and 50 characters")
                     String model,

                     @NotNull(message = "Year is required")
                     @Min(value = 1886, message = "Year must be after 1886")
                     @MaxCurrentYear
                     Integer year,

                     @NotNull(message = "Kilometers is required")
                     @Min(value = 0, message = "Kilometers cannot be negative")
                     @Max(value = 999999, message = "Kilometers value is unrealistic")
                     Integer kilometers
) { }
