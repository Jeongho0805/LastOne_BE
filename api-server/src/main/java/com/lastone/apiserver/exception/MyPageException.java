package com.lastone.apiserver.exception;

import com.lastone.core.exception.ErrorCode;
import com.lastone.core.exception.LastOneException;

public class MyPageException extends LastOneException {
    public MyPageException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public MyPageException(ErrorCode errorCode) {
        super(errorCode);
    }
}
