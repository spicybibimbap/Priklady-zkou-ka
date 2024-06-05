import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class CalculatorFrame extends JFrame {

    public CalculatorFrame() throws IOException {
        setTitle("Příklady k ověření");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // cesta k JSON souboru
        List<Example> examples = null;
        try {
            examples = ExampleReader.readExamples("priklPlus.json");
        } catch (IOException e) {
            System.out.println("Chyba pri čtení souboru!");
        }
        ExampleStatistics stats = ExampleEvaluator.evaluateExamples(examples);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.lightGray);

        JTextArea incorrectExamplesArea = new JTextArea();
        incorrectExamplesArea.setEditable(false);
        incorrectExamplesArea.setBackground(new Color(230, 161, 190));
        for (Example example : stats.getIncorrectExamples()) {
            incorrectExamplesArea.append(example.getA() + " " + example.getOper() + " " + example.getB() + " = " + example.getVysl() + "\n");
        }

        JPanel statsPanel = new JPanel(new GridLayout(3, 1));
        statsPanel.setBackground(new Color(237, 12, 108));

        Font labelFont = new Font("Verdana", Font.PLAIN, 18);

        JLabel totalExamplesLabel = new JLabel("Příkladů celkem: " + stats.getTotalExamples());
        totalExamplesLabel.setForeground(Color.WHITE);
        totalExamplesLabel.setFont(labelFont); 
        statsPanel.add(totalExamplesLabel);

        JLabel correctExamplesLabel = new JLabel("Správných výsledků: " + stats.getCorrectExamples());
        correctExamplesLabel.setForeground(Color.WHITE);
        correctExamplesLabel.setFont(labelFont);
        statsPanel.add(correctExamplesLabel);

        JLabel incorrectExamplesLabel = new JLabel("Nesprávných výsledků: " + stats.getIncorrectExamples().size());
        incorrectExamplesLabel.setForeground(Color.WHITE);
        incorrectExamplesLabel.setFont(labelFont);
        statsPanel.add(incorrectExamplesLabel);

        panel.add(new JScrollPane(incorrectExamplesArea), BorderLayout.CENTER);
        panel.add(statsPanel, BorderLayout.SOUTH);

        add(panel);
        getContentPane().setBackground(Color.lightGray);
    }
}