package com.sanpang;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)  {

        Car<Object> car = new Car();
        System.out.println(Arrays.asList(car.getClass().getTypeParameters()));
    }


}
