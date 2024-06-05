import java.util.ArrayList;
import java.util.List;

public class ExampleEvaluator {
    public static ExampleStatistics evaluateExamples(List<Example> examples) {
        List<Example> incorrectExamples = new ArrayList<>();
        int correctCount = 0;

        for (Example example : examples) {
            int expectedResult;
            switch (example.getOper()) {
                case "+":
                    expectedResult = example.getA() + example.getB();
                    break;
                // Pokud by byly i jiné operace, přidejte je sem
                default:
                    continue; // Přeskočíme neznámé operace
            }

            if (expectedResult != example.getVysl()) {
                incorrectExamples.add(example);
            } else {
                correctCount++;
            }
        }

        return new ExampleStatistics(examples.size(), correctCount, incorrectExamples);
    }
}