import javax.swing.*;

class BadCharacterException extends IllegalArgumentException {

    BadCharacterException() {
        JOptionPane window = new JOptionPane();
        JOptionPane.showMessageDialog(window, "Bad character found in expression.", "Illegal Character", JOptionPane.ERROR_MESSAGE);
    }
}