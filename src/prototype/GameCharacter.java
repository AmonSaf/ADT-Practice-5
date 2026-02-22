package prototype;

import java.util.*;

public class GameCharacter implements Cloneable {

    private String name;
    private int health, strength, agility, intelligence;
    private Weapon weapon;
    private Armor armor;
    private List<Skill> skills;

    public GameCharacter(String name, int health, int strength, int agility, int intelligence,
                         Weapon weapon, Armor armor, List<Skill> skills) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.weapon = weapon;
        this.armor = armor;
        this.skills = skills;
    }

    public String getName() { return name; }
    public Weapon getWeapon() { return weapon; }
    public Armor getArmor() { return armor; }
    public List<Skill> getSkills() { return skills; }

    @Override
    public GameCharacter clone() {
        try {
            GameCharacter cloned = (GameCharacter) super.clone();
            cloned.weapon = weapon.clone();
            cloned.armor = armor.clone();
            cloned.skills = new ArrayList<>();
            for (Skill s : skills) cloned.skills.add(s.clone());
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Character: ").append(name).append("\n")
          .append("HP: ").append(health).append(", STR: ").append(strength)
          .append(", AGI: ").append(agility).append(", INT: ").append(intelligence).append("\n")
          .append("Weapon: ").append(weapon).append("\n")
          .append("Armor: ").append(armor).append("\n")
          .append("Skills: ");
        for (Skill s : skills) sb.append(s).append("; ");
        return sb.toString();
    }
}