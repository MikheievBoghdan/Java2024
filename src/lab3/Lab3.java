package lab3;  // Оскільки клас знаходиться в пакеті lab3

import javax.swing.*;
import java.awt.*;

public class Lab3 {

    public static void execute() {
        // Створення вікна для лабораторної роботи
        JFrame labFrame = new JFrame("Лабораторна робота 3");
        labFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Закриття вікна
        labFrame.setSize(400, 300);
        labFrame.setLayout(new FlowLayout());

        // Створення компонентів для введення значень x та y
        JLabel xPromptLabel = new JLabel("Введіть значення x:");
        JTextField xInputField = new JTextField(10);
        JLabel yPromptLabel = new JLabel("Введіть значення y:");
        JTextField yInputField = new JTextField(10);
        JButton calculateButton = new JButton("Обчислити");
        JLabel resultLabel = new JLabel("Результат: ");

        // Додавання компонентів до вікна
        labFrame.add(xPromptLabel);
        labFrame.add(xInputField);
        labFrame.add(yPromptLabel);
        labFrame.add(yInputField);
        labFrame.add(calculateButton);
        labFrame.add(resultLabel);

        // Дія кнопки для обчислення
        calculateButton.addActionListener(e -> {
            try {
                // Введення значень x та y
                double x = Double.parseDouble(xInputField.getText());
                double y = Double.parseDouble(yInputField.getText());

                final double a = 1.4;
                final double b = 8.8;

                if (y <= 0) {
                    resultLabel.setText("Значення y повинно бути більше ніж 0.");
                    return;
                }

                double sqrtValue = x + b - a;
                double numerator;

                if (sqrtValue >= 0) {
                    numerator = Math.sqrt(sqrtValue) + Math.log(y);
                } else {
                    resultLabel.setText("Вхідне значення для квадратного кореня є негативним.");
                    return;
                }

                double denominator = Math.atan(b + a);

                if (denominator == 0) {
                    resultLabel.setText("Знаменник дорівнює нулю.");
                } else {
                    double T = numerator / denominator;
                    resultLabel.setText("Результат: " + String.format("%.4f", T));
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Будь ласка, введіть коректні числові значення для x і y.");
            }
        });

        // Відображення вікна лабораторної роботи
        labFrame.setVisible(true);
    }
}
