import javax.swing.*;
import java.awt.event.ActionEvent;

public class InfixMain {

    private JTextField inputField, resultField;

    public static void main(String[] args) {
        InfixMain infix = new InfixMain();
        infix.instantiateGUI();
    }

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

        inputField = new JTextField("", 20);
        inputField.setBounds(175, 5, inputField.getPreferredSize().width, inputField.getPreferredSize().height);
        panel.add(inputField);

        resultField = new JTextField("", 20);
        resultField.setBounds(125, 100, resultField.getPreferredSize().width, resultField.getPreferredSize().height);
        panel.add(resultField);

        JButton submitButton = new JButton("Evaluate");
        submitButton.setBounds(200, 50, submitButton.getPreferredSize().width, submitButton.getPreferredSize().height);
        submitButton.addActionListener((ActionEvent e) -> {
            if (!inputField.getText().equals("")) {
                submitButton();
            }
        });
        panel.add(submitButton);

        window.getRootPane().setDefaultButton(submitButton);
        window.setSize(500, 175);
        window.setVisible(true);
    }

    private void submitButton() {
        InfixEvaluation infixEvaluation = new InfixEvaluation();
        int result = infixEvaluation.InfixEvaluation(inputField.getText());
        resultField.setText("" + result);
    }
}
