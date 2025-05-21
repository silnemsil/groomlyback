package ee.valiit.groomlyback.infrastructure.error;

import lombok.Data;//custom klass, mis annab struktuuri kind DTO, klassist saab teha objekti, saab teha JSONiks

@Data
public class ApiError {
    private String message; // NULL
    private Integer errorCode; // NULL
}

