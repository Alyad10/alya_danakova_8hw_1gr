package kg.geektech.game.players;

public class Golem extends Hero {


    public Golem(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.FLY_SPEED);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

    }
}