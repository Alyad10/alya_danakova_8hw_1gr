package kg.geektech.game.players;

import java.util.Random;

public class Berserk extends Hero {
    public int getSavedDamage() {
        return savedDamage;
    }

    private int savedDamage;

    public Berserk(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    public void setSavedDamage(int savedDamage) {
        this.savedDamage = savedDamage;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (boss.getDamage() >= this.getDamage()) {
            boss.setHealth(boss.getHealth() - this.getDamage() + (savedDamage - 20));
        }




        }

    }

