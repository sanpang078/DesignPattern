package com.sanpang;

public class Car<T> {
    private T id;

    public void setId(T id){
        this.id = id;
    }
    public T getId(){
        return id;
    }
}
