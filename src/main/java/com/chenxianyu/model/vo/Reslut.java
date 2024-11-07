package com.chenxianyu.model.vo;

public class Reslut<T> {
    private final int code;
    private final String message;
    private final T data;

    public Reslut(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T>Reslut<T> succeed(){
        return new Reslut<>(1,"succeed",null);
    }

    public static <T>Reslut<T> succeed(T data){
        return new Reslut<>(1,"succeed",data);
    }

    public static <T>Reslut<T> error(String message){
        return new Reslut<>(0,message,null);
    }
}
