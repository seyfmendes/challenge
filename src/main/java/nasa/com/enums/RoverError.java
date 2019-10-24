package nasa.com.enums;

public enum RoverError {

    OUT_OF_AREA_EXCEPTION(2000, "Check Coordination"),

    PARS_EXCEPTION(3000, "Parse Exception");

    private final int code;
    private final String message;

    RoverError(int code, String messages) {
        this.code = code;
        this.message = messages;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
