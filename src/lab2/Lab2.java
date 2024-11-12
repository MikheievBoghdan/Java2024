package lab2;  // Оскільки клас знаходиться в пакеті lab2

import javax.swing.*;
import java.awt.*;

public class Lab2 {

    public static void execute() {
        // Створення вікна для лабораторної роботи
        JFrame labFrame = new JFrame("Лабораторна робота 2");
        labFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Закриття вікна
        labFrame.setSize(400, 300);
        labFrame.setLayout(new FlowLayout());

        // Створення компонентів для введення значення x
        JLabel promptLabel = new JLabel("Введіть значення x:");
        JTextField inputField = new JTextField(10);
        JButton calculateButton = new JButton("Обчислити");
        JLabel resultLabel = new JLabel("Результат: ");

        // Додавання компонентів до вікна
        labFrame.add(promptLabel);
        labFrame.add(inputField);
        labFrame.add(calculateButton);
        labFrame.add(resultLabel);

        // Дія кнопки для обчислення
        calculateButton.addActionListener(e -> {
            try {
                // Введення значення x
                double x = Double.parseDouble(inputField.getText());

                // Ініціалізація змінних
                final double a = 1.4;
                final double b = 8.8;
                final double y = 17.0;

                // Перевірка значення y для натурального логарифму
                if (y <= 0) {
                    resultLabel.setText("Значення y повинно бути більше ніж 0.");
                    return;
                }

                // Обчислення чисельника
                double sqrtValue = x + b - a;
                double numerator = Double.NaN;

                if (sqrtValue >= 0) {
                    numerator = Math.sqrt(sqrtValue) + Math.log(y);
                } else {
                    resultLabel.setText("Вхідне значення для квадратного кореня є негативним.");
                    return;
                }

                // Обчислення знаменника
                double denominator = Math.atan(b + a);

                // Перевірка на нульовий знаменник
                if (denominator == 0) {
                    resultLabel.setText("Знаменник дорівнює нулю.");
                } else {
                    if (Double.isNaN(numerator)) {
                        resultLabel.setText("Чисельник обчислений як NaN.");
                    } else {
                        double T = numerator / denominator;
                        // Виведення результату
                        resultLabel.setText("Результат: " + String.format("%.4f", T));
                    }
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Будь ласка, введіть коректне значення для x.");
            }
        });

        // Відображення вікна лабораторної роботи
        labFrame.setVisible(true);
    }
}
