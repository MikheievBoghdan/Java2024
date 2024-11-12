package lab7;

import javax.swing.*;
import java.awt.*;

public class Lab7 {
    public static void execute() {
        // Створення вікна для лабораторної роботи
        JFrame frame = new JFrame("Лабораторна робота 7");
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Панель для виведення результату
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        frame.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        // Створення об'єкта Weapon
        Weaponv2 rifle = new Weaponv2("Assault Rifle", 120);

        // Створення об'єкта SoldierPrivatev2
        Soldierv2 privateSoldier = new SoldierPrivatev2("John Doe", 25, rifle);
        resultArea.append("Private Soldier Info:\n");
        privateSoldier.showInfo(resultArea);
        resultArea.append(privateSoldier.performCombat() + "\n");

        // Створення об'єкта Officerv2
        Soldierv2 officer = new Officerv2("Jane Smith", 35, rifle, "Captain");
        resultArea.append("\nOfficer Info:\n");
        officer.showInfo(resultArea);
        resultArea.append(officer.performCombat() + "\n");

        // Налаштування поведінки при закритті
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
