import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lab1.Lab1;
import lab2.Lab2;
import lab3.Lab3;
import lab4.Lab4;
import lab5.Lab5;
import lab6.Lab6;
import lab7.Lab7;

public class Main {

    public static void main(String[] args) {
        // Створення основного вікна
        JFrame frame = new JFrame("Лабораторні роботи");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());

        // Панель для вибору лабораторних робіт
        JPanel labPanel = new JPanel();
        labPanel.setLayout(new GridLayout(7, 1));  // Для 7 лабораторних робіт

        // Створення кнопок для кожної лабораторної роботи
        for (int i = 1; i <= 7; i++) {
            final int labNumber = i;  // Копія змінної i
            JButton labButton = new JButton("Лабораторна робота " + i);
            labButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Тут викликаються методи для виконання відповідних лабораторних робіт
                    System.out.println("Вибрана лабораторна робота " + labNumber);
                    switch (labNumber) {
                        case 1:
                            Lab1.execute();  // Викликає метод execute() для 1-ї лабораторної роботи
                            break;
                        case 2:
                            Lab2.execute();  // Викликає метод execute() для 2-ї лабораторної роботи
                            break;
                        case 3:
                            Lab3.execute();  // Викликає метод execute() для 3-ї лабораторної роботи
                            break;
                        case 4:
                            Lab4.execute();  // Викликає метод execute() для 4-ї лабораторної роботи
                            break;
                        case 5:
                            Lab5.execute();  // Викликає метод execute() для 5-ї лабораторної роботи
                            break;
                        case 6:
                            Lab6.execute();  // Викликає метод execute() для 6-ї лабораторної роботи
                            break;
                        case 7:
                            Lab7.execute();  // Викликає метод execute() для 7-ї лабораторної роботи
                            break;
                        default:
                            System.out.println("Невідома лабораторна робота");
                    }
                }
            });
            labPanel.add(labButton);
        }

        // Панель для інформації про автора
        JPanel authorPanel = new JPanel();
        authorPanel.setLayout(new GridBagLayout());  // Використовуємо GridBagLayout для кращого управління компонентами
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Додаємо відступи для компонент

        // Додавання текстової інформації про автора
        JTextArea authorInfo = new JTextArea();
        authorInfo.setText("Автор: Міхеєв Богдан\n" +
                "Спеціальність: Комп'ютерна інженерія\n" +
                "Контакти: ki21-b.mikheiev@nubip.edu.ua\n");
        authorInfo.setEditable(false);  // Зробити текстове поле лише для читання
        authorInfo.setPreferredSize(new Dimension(200, 100));  // Встановлюємо розмір текстового поля

        gbc.gridx = 0;  // Вказуємо першу колонку
        gbc.gridy = 0;  // Вказуємо перший рядок
        gbc.gridwidth = 1;  // Текст займає одну клітинку
        gbc.gridheight = 1;
        authorPanel.add(authorInfo, gbc);  // Додаємо текст до панелі

        // Додавання фото автора
        String imagePath = "C:/Users/Mikheiev Boghdan/Desktop/Java/Project1/JavaProject1/src/inf_about_me.png"; // Ваш шлях до зображення
        ImageIcon authorImage = new ImageIcon(imagePath);
        if (authorImage.getImageLoadStatus() != MediaTracker.COMPLETE) {
            System.out.println("Зображення не завантажено. Перевірте шлях до файлу.");
        }

        // Масштабування зображення
        Image image = authorImage.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH); // Розмір 150x150
        authorImage = new ImageIcon(image);  // Оновлення ImageIcon з новим розміром

        JLabel imageLabel = new JLabel(authorImage);

        // Додавання зображення в іншу клітинку
        gbc.gridx = 0;  // Вказуємо першу колонку
        gbc.gridy = 1;  // Вказуємо наступний рядок
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        authorPanel.add(imageLabel, gbc);  // Додаємо зображення

        // Панель для перемикання між вибором лабораторних робіт і інформацією про автора
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, labPanel, authorPanel);
        splitPane.setDividerLocation(300); // Розмір розділення
        frame.add(splitPane);

        // Відображення вікна
        frame.setVisible(true);
    }
}
