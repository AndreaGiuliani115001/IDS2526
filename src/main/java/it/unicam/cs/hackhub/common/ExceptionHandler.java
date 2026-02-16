package it.unicam.cs.hackhub.common;

/**
 * Handles ServiceException for controller layer. Controllers catch
 * ServiceException,
 * call handle(ex), and use the result (e.g. return null or propagate error).
 */
public final class ExceptionHandler {

    private ExceptionHandler() {
    }

    /**
     * Handles the given ServiceException and returns an error result for the
     * controller.
     */
    public static ExceptionResult handle(ServiceException ex) {
        return new ExceptionResult(ex.getErrorCode(), ex.getMessage());
    }

    public static final class ExceptionResult {
        private final ErrorCode errorCode;
        private final String message;

        public ExceptionResult(ErrorCode errorCode, String message) {
            this.errorCode = errorCode;
            this.message = message;
        }

        public ErrorCode getErrorCode() {
            return errorCode;
        }

        public String getMessage() {
            return message;
        }
    }
}
