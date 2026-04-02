package auto.trace.dto.response;

public record CarResponse(Long id,
                          Long brandId,
                          String brandName,
                          String logoUrl,
                          Long modelId,
                          String modelName,
                          Integer year,
                          Integer kilometers
) { }
