import javax.swing.*;

class DivideByZeroException extends ArithmeticException {

    DivideByZeroException() {
        JOptionPane window = new JOptionPane();
        JOptionPane.showMessageDialog(window, "Sorry, you cannot divide by zero.");
    }
}