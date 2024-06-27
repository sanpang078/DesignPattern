package org.example.behavior.interpreter;

import java.util.Deque;
import java.util.LinkedList;

public class ExpressionInterpreter {

    private Deque<Expression> numbers = new LinkedList();

    public long interpret(String expression){
        String[] elements = expression.split(" ");
        int length = elements.length;
        for (int i = 0; i < (length + 1)/2; i++ ) {
            numbers.addLast(new NumberExpression(elements[i]));
        }

        for (int i = (length+1)/2; i < length; i++) {
            String operator = elements[i];
            boolean isValid = "+".equals(operator) || "-".equals(operator) || "*".equals(operator) || "/".equals(operator);
            if ( !isValid ) {
                throw new RuntimeException("Expression is invalid: " + expression);
            }

            Expression exp1 = numbers.pollFirst();
            Expression exp2 = numbers.pollFirst();
            Expression combineExp = null;

            if ( operator.equals("+") ) {
                combineExp = new AdditionExpression(exp1, exp2);
            } else if (operator.equals("-")) {
                combineExp = new SubstractExpression(exp1, exp2);
            } else if (operator.equals("*")) {
                combineExp = new MultiplicationExpression(exp1, exp2);
            } else if (operator.equals("/")) {
                combineExp = new DivisionExpression(exp1, exp2);
            }
            numbers.addFirst(combineExp);
        }

        if (numbers.size() != 1) {
            throw new RuntimeException("expression is invalid:" + expression);
        }

        return numbers.pop().interpret();
    }

}
