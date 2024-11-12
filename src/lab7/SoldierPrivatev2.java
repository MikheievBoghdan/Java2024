package lab7;

import javax.swing.*;

public class SoldierPrivatev2 extends Soldierv2 implements Combatv2 {
    private String rank;

    // Конструктор за замовчуванням
    public SoldierPrivatev2(String name, int age, Weaponv2 weapon) {
        super(name, age, weapon);  // Викликає конструктор базового класу Soldierv2
        this.rank = "Private";
    }

    // Реалізація абстрактного методу performCombat
    @Override
    public String performCombat() {
        return getName() + " is performing basic combat.";
    }

    // Перевизначення методу showInfo
    @Override
    public void showInfo(JTextArea textArea) {
        super.showInfo(textArea);  // Викликає метод showInfo() з базового класу
        textArea.append("Rank: " + rank + "\n");
    }
}
