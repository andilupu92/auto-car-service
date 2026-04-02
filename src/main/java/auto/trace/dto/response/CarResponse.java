package auto.trace.dto.response;

public record CarResponse(Long id,
                          Long brandId,
                          String brandName,
                          Long modelId,
                          String modelName,
                          Integer year,
                          Integer kilometers
) { }
