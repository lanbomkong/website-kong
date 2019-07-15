package com.biosh.owner.web;

/**
 * @description
 * @date 2019/7/11
 */
public enum Status {
    CONTINUE(100),
    OK(200),
    FOUND(300);

    private int code;

    Status(int code) {
        this.code = code;
    }
}
