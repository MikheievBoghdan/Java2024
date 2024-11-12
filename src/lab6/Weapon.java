package lab6;

public class Weapon {
    private String name;
    private int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    // Метод для отримання інформації про зброю
    public String getWeaponInfo() {
        return "Weapon: " + name + ", Damage: " + damage;
    }
}
