package lab5;  // Оскільки клас знаходиться в пакеті lab5

import calculator.ExpressionCalculator;
import javax.swing.*;
import java.awt.*;

public class Lab5 {

    public static void execute() {
        // Створення вікна для лабораторної роботи
        JFrame labFrame = new JFrame("Лабораторна робота 5");
        labFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Закриття вікна
        labFrame.setSize(500, 400);
        labFrame.setLayout(new FlowLayout());

        // Створення компонентів для введення значень N та y
        JLabel nPromptLabel = new JLabel("Введіть номер вашого варіанту (N):");
        JTextField nInputField = new JTextField(10);
        JLabel yPromptLabel = new JLabel("Введіть значення y:");
        JTextField yInputField = new JTextField(10);
        JButton calculateButton = new JButton("Обчислити");
        JTextArea resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Додавання компонентів до вікна
        labFrame.add(nPromptLabel);
        labFrame.add(nInputField);
        labFrame.add(yPromptLabel);
        labFrame.add(yInputField);
        labFrame.add(calculateButton);
        labFrame.add(scrollPane);

        // Дія кнопки для обчислення
        calculateButton.addActionListener(e -> {
            try {
                // Введення значень N та y
                int N = Integer.parseInt(nInputField.getText());
                double y = Double.parseDouble(yInputField.getText());

                if (y <= 0) {
                    resultArea.setText("Значення y повинно бути більше ніж 0.");
                    return;
                }

                // Демонстрація роботи двох конструкторів
                ExpressionCalculator calculator1 = new ExpressionCalculator(1.4, 8.8, y, N);
                ExpressionCalculator calculator2 = new ExpressionCalculator();

                double startX = -10 - 2.5 * N;
                double endX = 5 + 1.2 * N;
                double deltaX = 0.5 + N / 20.0;

                StringBuilder resultText = new StringBuilder();

                // Використання нестатичного методу
                resultText.append("Результати для нестатичного методу:\n");
                for (double x = startX; x <= endX; x += deltaX) {
                    try {
                        double result = calculator1.calculate(x);
                        resultText.append(String.format("x = %.2f, T = %.4f\n", x, result));
                    } catch (ArithmeticException ex) {
                        resultText.append("Помилка: " + ex.getMessage() + "\n");
                    }
                }

                // Використання статичного методу
                resultText.append("\nРезультати для статичного методу:\n");
                for (double x = startX; x <= endX; x += deltaX) {
                    try {
                        double result = ExpressionCalculator.calculateStatic(1.4, 8.8, y, x);
                        resultText.append(String.format("x = %.2f, T = %.4f\n", x, result));
                    } catch (ArithmeticException ex) {
                        resultText.append("Помилка: " + ex.getMessage() + "\n");
                    }
                }

                // Виведення результату
                resultArea.setText(resultText.toString());

            } catch (NumberFormatException ex) {
                resultArea.setText("Будь ласка, введіть коректні числові значення для N і y.");
            }
        });

        // Відображення вікна лабораторної роботи
        labFrame.setVisible(true);
    }
}
