package prototype;

public class Armor implements Cloneable {

    private String name;
    private int defense;

    public Armor(String name, int defense) {
        this.name = name;
        this.defense = defense;
    }

    public String getName() { return name; }
    public int getDefense() { return defense; }

    @Override
    public Armor clone() {
        try {
            return (Armor) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return name + " (Defense: " + defense + ")";
    }
}