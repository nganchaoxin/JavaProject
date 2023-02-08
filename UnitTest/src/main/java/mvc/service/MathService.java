package mvc.service;

public class MathService {
    MathHelper mathHelper;
    public MathService (MathHelper mathHelper) {
        this.mathHelper = mathHelper;

    }
    public int add(int a, int b) {
        return mathHelper.add(a,b);
    }
    double divide(int a , int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return mathHelper.divide(a, b);
    }
}
