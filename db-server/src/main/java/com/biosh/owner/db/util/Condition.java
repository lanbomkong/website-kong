package com.biosh.owner.db.util;

/**
 * @description
 * @date 2019/6/20
 */
public class Condition {

    private String key;

    private String operate;

    private String value;

    public Condition(String key, String value) {
        this.key = key;
        this.operate = "=";
        this.value = value;
    }

    public Condition(String key, String operate, String value) {
        this.key = key;
        this.operate = operate;
        this.value = value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getOperate() {
        return operate;
    }

    public String getValue() {
        return value;
    }
}
