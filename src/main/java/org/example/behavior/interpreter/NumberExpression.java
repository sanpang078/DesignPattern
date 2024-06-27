package org.example.behavior.interpreter;

public class NumberExpression implements Expression{
    private long number;

    public NumberExpression(long number ){
        this.number = number;
    }

    public NumberExpression(String number ){
        this.number = Long.parseLong(number);
    }
    @Override
    public Long interpret() {
        return number;
    }
}
