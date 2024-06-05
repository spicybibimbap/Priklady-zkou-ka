import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Example {
    private int a;
    private String oper;
    private int b;
    private int vysl;

    public int getA() {
        return a;
    }

    public String getOper() {
        return oper;
    }

    public int getB() {
        return b;
    }

    public int getVysl() {
        return vysl;
    }

}