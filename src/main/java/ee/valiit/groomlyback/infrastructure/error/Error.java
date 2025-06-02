package ee.valiit.groomlyback.infrastructure.error;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111), //peavad olema komaaga eraldatud, ainult VIIMASEL semikoolon
    NO_GROOMER_LOCATIONS_FOUND("Ei leitud ühtegi lemmiklooma iluteenindaja asukohta", 222),
    NO_GROOMERS_FOUND("", 203),
    LOCATION_NAME_UNAVAILABLE("Sellise nimega lemmiklooma iluteenindaja asukoht on juba süsteemis olemas", 333),
    USERNAME_UNAVAILABLE("Sellise kasutajanimega kasutaja on juba olemas",444);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

}
