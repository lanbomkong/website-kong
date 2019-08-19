package com.biosh.owner.common.constants;

/**
 * @description
 * @date 2019/8/5
 */
public enum  RetStubDetailInfo implements RetStub{
    NEED_LOGIN(401,"meed login!"),

    OUTPUT_NOT_SUPPORTED(100001, "output not supported"),

    EXTENSION_NOT_SUPPORTED(100002,"extension not supported")
    ;

    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    RetStubDetailInfo(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
