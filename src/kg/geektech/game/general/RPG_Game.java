package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {

    private static int roundNumber;
    public static Random random = new Random();

    public static void startGame() {
        Boss boss = new Boss(1000, 50, "Helkart");

        Warrior warrior = new Warrior(270, 10, "Artur");
        Medic doc = new Medic(250, 5, 10, "Aibolit");
        Magic magic = new Magic(260, 20, "Merlin");
        Berserk berserk = new Berserk(280, 15, "Ragnar");
        Medic assistant = new Medic(290, 10, 5, "Malysh");
        Golem golem = new Golem(350, 2,"Henkok");


        Hero[] heroes = {warrior, doc, magic, berserk, assistant,golem};



        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            playRound(boss, heroes, golem);
        }
    }






    private static void playRound(Boss boss, Hero[] heroes, Golem golem) {
        roundNumber++;
        boss.chooseDefence(heroes);
        boss.attack(heroes, golem);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getAbility() != boss.getDefence() && heroes[i].getHealth() > 0) {

                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
           /* for (int i = 0; i < heroes.length; i++) {

            }*/

        }
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " ----------------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

}
