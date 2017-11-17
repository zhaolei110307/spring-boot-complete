package com.zhaolei.spring_boot;

public enum ResultEnum {

    XIAO_XUE(101,"小学生"),
    ZHONG_XUE(102,"中学生"),
    OTHER(100000,"不确定");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
