package org.example.behavior.interpreter;

public class AdditionExpression implements Expression{
    private Expression exp1;
    private Expression exp2;

    public AdditionExpression(Expression exp1, Expression exp2){
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
    @Override
    public Long interpret() {
        return this.exp1.interpret() + this.exp2.interpret();
    }
}
