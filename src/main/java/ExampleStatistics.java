import java.util.List;

public class ExampleStatistics {
    private int totalExamples;
    private int correctExamples;
    private List<Example> incorrectExamples;

    public ExampleStatistics(int totalExamples, int correctExamples, List<Example> incorrectExamples) {
        this.totalExamples = totalExamples;
        this.correctExamples = correctExamples;
        this.incorrectExamples = incorrectExamples;
    }

    public int getTotalExamples() {
        return totalExamples;
    }

    public int getCorrectExamples() {
        return correctExamples;
    }

    public List<Example> getIncorrectExamples() {
        return incorrectExamples;
    }
}