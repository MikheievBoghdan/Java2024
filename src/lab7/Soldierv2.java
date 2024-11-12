package lab7;

import javax.swing.*;

public abstract class Soldierv2 {
    private String name;  // Приватна змінна
    protected int age;
    private Weaponv2 weapon;

    // Конструктор з параметрами
    public Soldierv2(String name, int age, Weaponv2 weapon) {
        this.name = name;
        this.age = age;
        this.weapon = weapon;
    }

    // Геттер для отримання значення name
    public String getName() {
        return name;
    }

    // Абстрактний метод для реалізації в нащадках
    public abstract String performCombat();

    // Метод для виведення інформації про солдата
    public void showInfo(JTextArea textArea) {
        textArea.append("Name: " + name + ", Age: " + age + "\n");
        if (weapon != null) {
            textArea.append(weapon.getWeaponInfo() + "\n");
        }
    }
}
