
import java.util.Scanner;

public class Battle {

    private Monster player = new Player(Main.namePlayer, 100, 20, 0, 20, 0, 1);
    private Monster monster;


    public void fight(Monster player, Monster monster) {
        this.player = player;
        this.monster = monster;
        Runnable runnable = () -> {
            int turn = 1;
            boolean isFightEnded = false;
            while (!isFightEnded) {
                System.out.println("----Ход: " + turn + "----");
                if (turn++ % 2 != 0) {
                    isFightEnded = makeHit(monster, player);
                } else {
                    isFightEnded = makeHit(player, monster);
                }
                try {

                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    private Boolean makeHit(Monster defender, Monster attacker) {
        int hit = attacker.attack();
        int defenderHealth = defender.getHp() - hit;
        if (hit != 0) {
            System.out.println(String.format("%s Нанес удар в %d единиц!", attacker.getName(), hit));
            System.out.println(String.format("У %s осталось %d единиц здоровья...", defender.getName(), defenderHealth));
        } else {
            System.out.println(String.format("%s промахнулся!", attacker.getName()));
        }
        if (defenderHealth <= 0 && defender instanceof Player) {
            System.out.println("Извините, вы пали в бою...");
            System.out.println("Игра окончена");
            return true;
        } else if (defenderHealth <= 0) {
            System.out.println(String.format("Враг повержен! Вы получаете %d опыт и %d золота", defender.getExp(), defender.getGold()));
            attacker.setExp(attacker.getExp() + defender.getExp());
            attacker.setGold(attacker.getGold() + defender.getGold());
            parameters();
            helloInTheWorld();
            run();
            return true;
        } else {
            defender.setHp(defenderHealth);
            return false;
        }
    }

    public void helloInTheWorld() {
        System.out.println("1. Темный лес (можно получить по шее)");
        System.out.println("2. Торговец (можно купить зелья и отдохнуть)");
        System.out.println("3. Выйти из игры");
    }

    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("Вы нарвались на неприятности!");
                fight(player, Monster.createMonster());
                if (player.getHp() <= 0) {
                    break;
                }
            } else if (command == 2) {
                System.out.println("Вы попали к торговцу (будьте внимательны, он обвешивает)");
                System.out.println("1. Желаете купить зелье здоровья?");
                System.out.println("2. Желаете покинуть меня и вернуться к началу игры?");
                int command2 = scanner.nextInt();
                if (command2 == 1) {
                    System.out.println("Вы купили зелье здоровья и теперь здоровье полностью восстановлено!");
                    buy();
                    parameters();
                    helloInTheWorld();
                    run();
                } else if (command2 == 2) {
                    helloInTheWorld();
                    run();
                } else {
                    System.out.println("Неверная команда. Начните заново!");
                    helloInTheWorld();
                    run();
                }

            } else if (command == 3) {
                System.out.println("Игра окончена!");
                break;
            } else {
                System.out.println("Неверная команда. Начните заново!");
                helloInTheWorld();
                run();
            }
        }

    }

    public void parameters() {
        System.out.println("Игрок " + player.getName() + " имеет " + player.getHp() + " очков здоровья, " + player.getExp() + " очков опыта, " + player.getGold() + " золота.");
        System.out.println("И снова можно идти в бой!!!");

    }

    public int buy() {
        if (player.getHp() == 100) {
            return player.getHp();
        } else if (player.getHp() > 100) {
            return 100;
        } else
            return player.getHp() + Trader.healthPotion;
    }

    public void start() {
        run();
    }

}
