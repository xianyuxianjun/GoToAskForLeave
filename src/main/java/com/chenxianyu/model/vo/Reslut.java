package com.chenxianyu.model.vo;

import com.fasterxml.jackson.databind.ObjectMapper;

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
        ObjectMapper objectMapper = new ObjectMapper();
        return new Reslut(1,"succeed",null);
    }

    public static Reslut succeed(Object data){
        return new Reslut(1,"succeed",data);
    }

    public static Reslut error(String message){
        return new Reslut(0,message,null);
    }
}
