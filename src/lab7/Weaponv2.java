package lab7;

public class Weaponv2 {
    private String name;
    private int damage;

    public Weaponv2(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    // Метод для отримання інформації про зброю
    public String getWeaponInfo() {
        return "Weapon: " + name + ", Damage: " + damage;
    }
}
