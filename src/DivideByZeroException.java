import javax.swing.*;

/*+----------------------------------------------------------------------
 ||
 ||  Class InfixEvaluation
 ||
 ||         Author:  Lance Gundersen
 ||
 ||        Purpose:  Catch a divide by zero exception and show the user
 ||                  a message dialog.
 ||
 ++-----------------------------------------------------------------------*/

class DivideByZeroException extends ArithmeticException {

    DivideByZeroException() {
        JOptionPane window = new JOptionPane();
        JOptionPane.showMessageDialog(window, "Sorry, you cannot divide by zero.");
    }
}