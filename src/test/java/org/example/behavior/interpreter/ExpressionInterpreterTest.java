package org.example.behavior.interpreter;

public class ExpressionInterpreterTest {
    public static void main(String[] args) {

        ExpressionInterpreter interpreter = new ExpressionInterpreter();
        String expression = "8 3 2 4 - + *";
        System.out.println(interpreter.interpret(expression));
    }
}
