import java.util.Stack;
import java.util.StringTokenizer;

public class InfixEvaluation {

    private Stack<String> operatorStack;
    private Stack<Integer> operandStack;

    InfixEvaluation() {
        operatorStack = new Stack<>();
        operandStack = new Stack<>();
    }

    public int evaluate(String expression) {
        StringTokenizer tokenSplitter = new StringTokenizer(
                (expression.replaceAll("\\s+", "")), "()+-*/", true);

        while (tokenSplitter.hasMoreTokens()) {
            String token = tokenSplitter.nextToken();

            if (token.matches("[0-9]+")) {
                operandStack.push(Integer.parseInt(token));
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.peek().equals("(")) {
                    operandStack.push(evalOperation(operandStack.pop(), operandStack.pop(), operatorStack.pop()));
                }
                operatorStack.pop();
            } else if (isOperator(token)) {
                while (!operatorStack.empty() && hasPrecedence(token, operatorStack.peek()) && operandStack.size() > 1) {
                    operandStack.push(evalOperation(operandStack.pop(), operandStack.pop(), operatorStack.pop()));
                }
                operatorStack.push(token);
            } else {
                throw new BadCharacterException();
            }
        }

        while (!operatorStack.empty() && operandStack.size() > 1) {
            operandStack.push(evalOperation(operandStack.pop(), operandStack.pop(), operatorStack.pop()));
        }

        System.out.println("\nOriginal Expression: " + expression);
        System.out.println("Final Result:  " + operandStack.peek());
        return operandStack.pop();
    }

    private int evalOperation(int a, int b, String operator) throws DivideByZeroException {

        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return Math.abs(a - b);     //Unsigned subtraction
            case "*":
                return a * b;
            case "/":
                if (a != 0) {
                    return b / a;
                } else {
                    throw new DivideByZeroException();
                }
        }
        return -1;
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private boolean hasPrecedence(String a, String b) {
        return !b.equals("(") && !b.equals(")") && !((a.equals("*") || a.equals("/")) && (b.equals("+") || b.equals("-")));
    }
}
