import javax.swing.*;

/**
 * Your program is only expected to perform correctly on syntactically correct infix expressions
 * that contain integer operands and the four arithmetic operators + - * /. It should not,
 * however, require spaces between tokens. The usual precedence rules apply. The division
 * performed should be integer division. A check should be made for division by zero. Should the
 * expression contain division by zero, a checked exception DivideByZero should be thrown by
 * the method that performs the evaluation and caught in the main class, where a JOptionPane
 * window should be displayed containing an error message.
 */

public class InfixMain {

    private void instantiateGUI() {
        JFrame window = new JFrame("Infix Expression Evaluator");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = (JPanel) window.getContentPane();
        window.setLayout(null);

        JLabel inputLabel = new JLabel("Enter Infix Expression");
        inputLabel.setBounds(25, 5, inputLabel.getPreferredSize().width, inputLabel.getPreferredSize().height);
        panel.add(inputLabel);

        JLabel resultLabel = new JLabel("Result");
        resultLabel.setBounds(50, 100, resultLabel.getPreferredSize().width, resultLabel.getPreferredSize().height);
        panel.add(resultLabel);

        JTextField inputField = new JTextField("", 20);
        inputField.setBounds(175, 5, inputField.getPreferredSize().width, inputField.getPreferredSize().height);
        panel.add(inputField);

        JTextField resultField = new JTextField("", 20);
        resultField.setBounds(125, 100, resultField.getPreferredSize().width, resultField.getPreferredSize().height);
        panel.add(resultField);

        JButton submitButton = new JButton("Evaluate");
        submitButton.setBounds(200,50, submitButton.getPreferredSize().width, submitButton.getPreferredSize().height);
        //TODO: Add actionListener
        panel.add(submitButton);

        window.setSize(500, 175);
        window.setVisible(true);

    }

//    private void submitButton() {
//
//    }

    public static void main(String[] args) {
        InfixMain infix = new InfixMain();
        infix.instantiateGUI();
    }
}
