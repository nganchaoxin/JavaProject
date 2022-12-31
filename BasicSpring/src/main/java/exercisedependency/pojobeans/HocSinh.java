package exercisedependency.pojobeans;

public class HocSinh {
    private Compa compa;

    public Compa getCompa() {
        return compa;
    }

    public void setCompa(Compa compa) {
        this.compa = compa;
    }
    public void drawCircle(){
        compa.drawCircle();
    }
}
