package org.example.behavior.interpreter;

public class MultiplicationExpression implements Expression{
    private Expression exp1;
    private Expression exp2;

    public MultiplicationExpression(Expression exp1, Expression exp2){
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
    @Override
    public Long interpret() {
        return this.exp1.interpret() * this.exp2.interpret();
    }
}
