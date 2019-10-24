package nasa.com;

import nasa.com.enums.RoverError;

public class NasaException extends Exception {

    private int code;
    private String message;

    public NasaException(RoverError error) {
        super(error.getMessage());
        setCode(error.getCode());
        setMessage(error.getMessage());
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
