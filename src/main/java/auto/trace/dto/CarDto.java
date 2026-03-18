package auto.trace.dto;

import auto.trace.annotation.MaxCurrentYear;
import jakarta.validation.constraints.*;

public record CarDto(@NotNull(message = "Brand is required")
                     Long brandId,

                     @NotNull(message = "Model is required")
                     Long modelId,

                     @NotNull(message = "Year is required")
                     @Min(value = 1886, message = "Year must be after 1886")
                     @MaxCurrentYear
                     Integer year,

                     @NotNull(message = "Kilometers is required")
                     @Min(value = 0, message = "Kilometers cannot be negative")
                     @Max(value = 999999, message = "Kilometers value is unrealistic")
                     Integer kilometers
) { }
