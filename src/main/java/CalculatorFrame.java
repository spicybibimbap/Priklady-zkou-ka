import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class CalculatorFrame extends JFrame {

    public CalculatorFrame() throws IOException {
        setTitle("Calculator Examples");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // cesta k JSON souboru
        List<Example> examples = ExampleReader.readExamples("priklPlus.json");
        ExampleStatistics stats = ExampleEvaluator.evaluateExamples(examples);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.lightGray);

        JTextArea incorrectExamplesArea = new JTextArea();
        incorrectExamplesArea.setEditable(false);
        incorrectExamplesArea.setBackground(Color.lightGray);
        for (Example example : stats.getIncorrectExamples()) {
            incorrectExamplesArea.append(example.getA() + " " + example.getOper() + " " + example.getB() + " = " + example.getVysl() + "\n");
        }

        JPanel statsPanel = new JPanel(new GridLayout(3, 1));
        statsPanel.setBackground(Color.green);
        statsPanel.add(new JLabel("Total examples: " + stats.getTotalExamples()));
        statsPanel.add(new JLabel("Correct results: " + stats.getCorrectExamples()));
        statsPanel.add(new JLabel("Incorrect results: " + stats.getIncorrectExamples().size()));

        panel.add(new JScrollPane(incorrectExamplesArea), BorderLayout.CENTER);
        panel.add(statsPanel, BorderLayout.SOUTH);

        add(panel);
        getContentPane().setBackground(Color.lightGray);
    }
}