package ee.valiit.groomlyback;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE("A"),
    DELETED("D");

    private final String code;

    Status(String code) {
        this.code = code;
    }
}
