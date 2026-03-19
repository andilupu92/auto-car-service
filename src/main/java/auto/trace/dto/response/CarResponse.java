package auto.trace.dto.response;

public record CarResponse(Long id,
                          Long brandId,
                          Long modelId,
                          Integer year,
                          Integer kilometers
) { }
