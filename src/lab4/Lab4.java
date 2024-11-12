package lab4;  // Оскільки клас знаходиться в пакеті lab4

import javax.swing.*;
import java.awt.*;

public class Lab4 {

    public static void execute() {
        // Створення вікна для лабораторної роботи
        JFrame labFrame = new JFrame("Лабораторна робота 4");
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

                final double a = 1.4;
                final double b = 8.8;

                if (y <= 0) {
                    resultArea.setText("Значення y повинно бути більше ніж 0.");
                    return;
                }

                double startX = -10 - 2.5 * N;
                double endX = 5 + 1.2 * N;
                double deltaX = 0.5 + N / 20.0;

                StringBuilder resultText = new StringBuilder();

                // Обчислення і виведення значень за допомогою циклу for
                resultText.append("Результати для циклу for:\n");
                for (double x = startX; x <= endX; x += deltaX) {
                    double sqrtValue = x + b - a;
                    double numerator;
                    if (sqrtValue >= 0) {
                        numerator = Math.sqrt(sqrtValue) + Math.log(y);
                    } else {
                        resultText.append(String.format("Обчислення кореня квадратного неможливе для x = %.2f\n", x));
                        continue;
                    }
                    double denominator = Math.atan(b + a);
                    if (denominator == 0) {
                        resultText.append(String.format("Знаменник дорівнює нулю. Обчислення неможливе для x = %.2f\n", x));
                        continue;
                    }
                    double T = numerator / denominator;
                    resultText.append(String.format("x = %.2f, T = %.4f\n", x, T));
                }

                // Обчислення і виведення значень за допомогою циклу while
                resultText.append("\nРезультати для циклу while:\n");
                double x = startX;
                while (x <= endX) {
                    double sqrtValue = x + b - a;
                    double numerator;
                    if (sqrtValue >= 0) {
                        numerator = Math.sqrt(sqrtValue) + Math.log(y);
                    } else {
                        resultText.append(String.format("Обчислення кореня квадратного неможливе для x = %.2f\n", x));
                        x += deltaX;
                        continue;
                    }
                    double denominator = Math.atan(b + a);
                    if (denominator == 0) {
                        resultText.append(String.format("Знаменник дорівнює нулю. Обчислення неможливе для x = %.2f\n", x));
                        x += deltaX;
                        continue;
                    }
                    double T = numerator / denominator;
                    resultText.append(String.format("x = %.2f, T = %.4f\n", x, T));
                    x += deltaX;
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
