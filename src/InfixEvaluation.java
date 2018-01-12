import java.util.Stack;

/**
 * tokenize the string containing the expression
 * while there are more tokens
 * get the next token
 * if it is an operand
 * push it onto the operand stack
 * else if it is a left parenthesis
 * push it onto the operator stack
 * else if it is a right parenthesis
 * while top of the operator stack not a left parenthesis
 * pop two operands and an operator
 * perform the calculation
 * push the result onto the operand stack
 * else if it is an operator
 * while the operator stack is not empty and
 * the operator at the top of the stack has higher
 * or the same precedence than the current operator
 * pop two operands and perform the calculation
 * push the result onto the operand stack
 * push the current operator on the operators stack
 * while the operator stack is not empty
 * pop two operands and an operator
 * perform the calculation
 * push the result onto the operand stack
 * the final result is a the top of the operand stack
 */



public class InfixEvaluation {

    private Stack<String> operatorStack;
    private Stack<Integer> operandStack;

    public InfixEvaluation() {
        // TODO: Create Stacks
    }

//    public int evalute(String Expression) {
//
//    }
//
//    private int evalOperation(int a, int b, String operator) {
//
//    }
//
//    private boolean isOperator(String token) {
//
//    }
//
//    private boolean hasPrecedence(String a, String b) {
//
//    }

    private void dhowStacks(Stack<String> operators, Stack<Integer> values) {

    }
}
