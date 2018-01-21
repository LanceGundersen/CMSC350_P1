import java.util.Stack;
import java.util.StringTokenizer;
import static java.lang.Math.abs;

/*+----------------------------------------------------------------------
 ||
 ||  Class InfixEvaluation
 ||
 ||         Author:  Lance Gundersen
 ||
 ||        Purpose:  Split the inputted infix string into tokens and
 ||                  evaluate based on precedence and operator.
 ||
 ||  Inherits From:  None
 ||
 ||     Interfaces:  None
 ||
 |+-----------------------------------------------------------------------
 ||
 ||      Constants:  None
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  None
 ||
 ||  Class Methods:  InfixEvaluation takes one string argument which is
 ||                  the inputted string. It returns the two stacks for
 ||                  operator and operands.
 ||
 ||                  evalOperation takes two integer arguments and a string
 ||                  for the operator. It returns calculated answer.
 ||
 ||                  isOperator takes a string of the operator and returns
 ||                  a boolean to check if its a valid operator or not.
 ||
 ||                  hasPrecedence takes two strings and returns a boolean
 ||                  to see which string has precedence over the other.
 ||
 ||
 ||  Inst. Methods:  None
 ||
 ++-----------------------------------------------------------------------*/

class InfixEvaluation {

    private Stack<String> operatorStack = new Stack<>();
    private Stack<Integer> operandStack = new Stack<>();

    // This method is not a constructor.
    public int InfixEvaluation(String inputExpression) {

        StringTokenizer tokenSplitter = new StringTokenizer(
                (inputExpression.replaceAll("\\s+", "")), "()+-*/", true);

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
        return operandStack.pop();
    }

    private int evalOperation(int a, int b, String operator) {

        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return abs(a - b);
            case "*":
                return a * b;
            case "/":
                if (a != 0) {
                    return b / a;
                } else {
                    throw new DivideByZeroException();
                }
        }
        return 0;
    }

    private boolean isOperator(String token) {
        String VALID_OPERATORS = "+-*/";
        return VALID_OPERATORS.contains(token);
    }

    private boolean hasPrecedence(String a, String b) {
        return !b.equals("(") && !b.equals(")") && !((a.equals("*") || a.equals("/")) && (b.equals("+") || b.equals("-")));
    }

}
