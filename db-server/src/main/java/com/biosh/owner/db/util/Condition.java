package com.biosh.owner.db.util;

/**
 * @description
 * @date 2019/6/20
 */
public class Condition {

    private String key;

    private String operate = "=";

    private Object value;

    /**
     * 是否去符号化
     */
    private String remSymbol = "false";

    public Condition(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Condition(String key, String operate, Object value) {
        this.key = key;
        this.operate = operate;
        this.value = value;
    }

    public Condition(String key, String operate, Object value, String remSymbol) {
        this.key = key;
        this.operate = operate;
        this.value = value;
        this.remSymbol = remSymbol;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getOperate() {
        return operate;
    }

    public Object getValue() {
        return value;
    }

    public void setRemSymbol(String remSymbol) {
        this.remSymbol = remSymbol;
    }

    public String getRemSymbol() {
        return remSymbol;
    }
}
