package lab6;

import javax.swing.*;

public class Officer extends Soldier {
    private String rank;

    // Конструктор
    public Officer(String name, int age, Weapon weapon, String rank) {
        super(name, age, weapon);  // Викликаємо конструктор з батьківського класу Soldier
        this.rank = rank;
    }

    // Перевизначення методу для виведення інформації про офіцера
    @Override
    public void showInfo(JTextArea textArea) {
        super.showInfo(textArea);  // Викликаємо метод showInfo з батьківського класу
        textArea.append("Rank: " + rank + "\n");
    }
}
