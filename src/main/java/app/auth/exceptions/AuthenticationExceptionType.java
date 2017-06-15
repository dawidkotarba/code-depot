package app.auth.exceptions;

import app.common.exceptions.model.ExceptionType;

public enum AuthenticationExceptionType implements ExceptionType {
    WRONG_USERNAME, WRONG_PASSWORD
}
