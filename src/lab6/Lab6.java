package lab6;

import javax.swing.*;
import java.awt.*;

public class Lab6 {
    public static void execute() {
        // Створення вікна для лабораторної роботи
        JFrame frame = new JFrame("Лабораторна робота 6");
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Панель для виведення результату
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        frame.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        // Створення об'єкта Weapon
        Weapon rifle = new Weapon("Assault Rifle", 120);

        // Створення об'єкта Soldier
        Soldier soldier = new Soldier("John Doe", 25, rifle);
        resultArea.append("Soldier Info:\n");
        soldier.showInfo(resultArea);

        // Створення об'єкта Officer
        Officer officer = new Officer("Jane Smith", 35, rifle, "Captain");
        resultArea.append("\nOfficer Info:\n");
        officer.showInfo(resultArea);

        // Налаштування поведінки при закритті
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
