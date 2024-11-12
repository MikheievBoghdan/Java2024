package calculator;

public class ExpressionCalculator {
    private double a;
    private double b;
    private double y;
    private int N;

    // Конструктор з параметрами
    public ExpressionCalculator(double a, double b, double y, int N) {
        this.a = a;
        this.b = b;
        this.y = y;
        this.N = N;
    }

    // Конструктор за замовченням
    public ExpressionCalculator() {
        this.a = 1.4;
        this.b = 8.8;
        this.y = 1.0;
        this.N = 5;
    }

    // Геттери і сеттери
    public double getA() { return a; }
    public void setA(double a) { this.a = a; }

    public double getB() { return b; }
    public void setB(double b) { this.b = b; }

    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    public int getN() { return N; }
    public void setN(int N) { this.N = N; }

    // Нестатичний метод для обчислення виразу
    public double calculate(double x) {
        if (y <= 0) {
            throw new IllegalArgumentException("Значення y повинно бути більше ніж 0 для обчислення натурального логарифму.");
        }

        double sqrtValue = x + b - a;
        if (sqrtValue < 0) {
            throw new ArithmeticException("Обчислення кореня квадратного неможливе для x = " + x);
        }

        double numerator = Math.sqrt(sqrtValue) + Math.log(y);
        double denominator = Math.atan(b + a);
        if (denominator == 0) {
            throw new ArithmeticException("Знаменник дорівнює нулю для x = " + x);
        }
        return numerator / denominator;
    }

    // Статичний метод для обчислення виразу
    public static double calculateStatic(double a, double b, double y, double x) {
        if (y <= 0) {
            throw new IllegalArgumentException("Значення y повинно бути більше ніж 0 для обчислення натурального логарифму.");
        }

        double sqrtValue = x + b - a;
        if (sqrtValue < 0) {
            throw new ArithmeticException("Обчислення кореня квадратного неможливе для x = " + x);
        }

        double numerator = Math.sqrt(sqrtValue) + Math.log(y);
        double denominator = Math.atan(b + a);
        if (denominator == 0) {
            throw new ArithmeticException("Знаменник дорівнює нулю для x = " + x);
        }
        return numerator / denominator;
    }
}
