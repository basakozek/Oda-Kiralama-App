package org.basak.odakiralama.exception;
public class OdaKiralamaException extends RuntimeException {
    private ErrorType errorType;
    public OdaKiralamaException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
    public ErrorType getErrorType() {
        return errorType;
    }
}
