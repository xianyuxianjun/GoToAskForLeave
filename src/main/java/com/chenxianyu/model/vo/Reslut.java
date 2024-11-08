package com.chenxianyu.model.vo;

import lombok.Data;

@Data
public class Reslut {
    private final int code;
    private final String message;
    private final Object data;

    public Reslut(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public static Reslut succeed(){
        return new Reslut(1,"succeed",null);
    }

    public static Reslut succeed(Object data){
        return new Reslut(1,"succeed",data);
    }

    public static Reslut error(String message){
        return new Reslut(0,message,null);
    }
}
