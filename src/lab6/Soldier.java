package lab6;

import javax.swing.*;

public class Soldier {
    private String name;
    private int age;
    private Weapon weapon;

    // Конструктор
    public Soldier(String name, int age, Weapon weapon) {
        this.name = name;
        this.age = age;
        this.weapon = weapon;
    }

    // Метод для виведення інформації про солдата
    public void showInfo(JTextArea textArea) {
        textArea.append("Name: " + name + ", Age: " + age + "\n");
        textArea.append(weapon.getWeaponInfo() + "\n");
    }
}
