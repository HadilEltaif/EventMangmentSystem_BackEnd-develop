package com.Proxym.EventManagementSys.exception;

public enum errorCodes {
    USER_NOT_FOUND(1000),
    USER_NOT_VALID(1001),
    EVENT_NOT_FOUND(2000),
    EVENT_NOT_VALID(2001),
    CATEGORY_NOT_FOUND(3000),
    CATEGORY_NOT_VALID(3001),
    ROLE_NOT_FOUND(4000),
    ROLE_NOT_VALID(4001),
    COMMENT_NOT_VALID(5000),
    COMMENT_NOT_FOUND(5001)
    ;
    private int code;
    errorCodes(int code) {
        this.code=code;

    }

    public int getCode() {
        return code;
    }
}
