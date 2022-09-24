package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Boss extends GameEntity {
    private SuperAbility defence;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public void chooseDefence(Hero[] heroes) {
        int randomIndex = RPG_Game.random.nextInt(heroes.length);
        this.defence = heroes[randomIndex].getAbility();
    }

    public void attack(Hero[] heroes, Golem golem) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (heroes[i] instanceof Berserk){
                    ((Berserk) heroes[i]).setSavedDamage(this.getDamage());
                }

                if (!(heroes[i] instanceof Golem) && golem.getHealth() > 0){
                    int cooficent = this.getDamage() / 5;
                    heroes[i].setHealth(heroes[i].getHealth() - (this.getDamage() - cooficent));
                    golem.setHealth(golem.getHealth() - cooficent);
                }else {
                    heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
                }
            }

        }
    }

    public SuperAbility getDefence() {
        return defence;
    }

    @Override
    public String toString() {
        return "BOSS " + super.toString() + " defence: " +
                (this.getDefence() == null ? "No defence" : this.getDefence().toString());
    }
}
