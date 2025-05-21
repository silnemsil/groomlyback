package ee.valiit.groomlyback.infrastructure.error;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
    NO_GROOMER_LOCATIONS_FOUND("Ei leitud ühtegi groomeri asukohta", 222),
    LOCATION_NAME_UNAVAILABLE("Sellise nimega groomeri asukoht on juba süsteemis olemas", 333);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

}
