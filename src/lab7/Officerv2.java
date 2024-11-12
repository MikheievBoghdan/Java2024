package lab7;

import javax.swing.*;

public class Officerv2 extends Soldierv2 implements Combatv2 {
    private String rank;

    // Конструктор з параметрами
    public Officerv2(String name, int age, Weaponv2 weapon, String rank) {
        super(name, age, weapon);  // Викликає конструктор класу Soldierv2
        this.rank = rank;
    }

    // Реалізація абстрактного методу performCombat
    @Override
    public String performCombat() {
        return getName() + " is leading troops in combat.";
    }

    // Перевизначення методу showInfo
    @Override
    public void showInfo(JTextArea textArea) {
        super.showInfo(textArea);  // Викликає метод showInfo() з базового класу
        textArea.append("Rank: " + rank + "\n");
    }
}
