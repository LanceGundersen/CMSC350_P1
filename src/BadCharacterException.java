import javax.swing.*;

/*+----------------------------------------------------------------------
 ||
 ||  Class InfixEvaluation
 ||
 ||         Author:  Lance Gundersen
 ||
 ||        Purpose:  Catch an illegal character exception and show the user
 ||                  a message dialog.
 ||
 ++-----------------------------------------------------------------------*/

class BadCharacterException extends IllegalArgumentException {

    BadCharacterException() {
        JOptionPane window = new JOptionPane();
        JOptionPane.showMessageDialog(window, "Bad character found in expression.", "Illegal Character", JOptionPane.ERROR_MESSAGE);
    }
}