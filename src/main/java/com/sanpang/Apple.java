package com.sanpang;

public class Apple implements Fruit<Integer> {
    @Override
    public Integer get(Integer param) {
        return param;
    }
}
