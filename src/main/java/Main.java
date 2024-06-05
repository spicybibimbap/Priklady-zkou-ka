import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new CalculatorFrame().setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}