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

    public void setA(int a) {
        this.a = a;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getVysl() {
        return vysl;
    }

    public void setVysl(int vysl) {
        this.vysl = vysl;
    }
}