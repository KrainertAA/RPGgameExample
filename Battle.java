import java.util.Random;
import java.util.Scanner;

public class Battle {

    final static private int MAX = 3;

    private Monster[] entities;
    private int n = 0;

    Battle() {
        entities = new Monster[MAX];
    }

    public void add(Monster monster) {
        if (n < MAX) {
            entities[n++] = monster;
        } else {
            System.out.println("Превышено число игроков!");
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Темный лес (можно получить по шее)");
        System.out.println("2. Торговец (можно купить зелья и отдохнуть)");
        System.out.println("3. Выйти из игры");
        int command = scanner.nextInt();
        if (command == 1) {
            System.out.println("Вы нарвались на неприятности!");
            Random random = new Random();
            int destroyed = 0;
            while (destroyed != n - 1) {
                Monster fighter = entities[random.nextInt(n)];
                Monster victim = entities[random.nextInt(n)];
                while (fighter == null || victim == null || !(fighter instanceof Attack) || fighter == victim) {
                    victim = entities[random.nextInt(n)];
                    fighter = entities[random.nextInt(n)];
                }
                ((Attack) fighter).attack(victim);
                if (victim.isDestroyed()) {
                    victim = null;
                    destroyed++;
                }
            }

            System.out.println("Битва окончена!");
            run();
        } else if (command == 2) {
            System.out.println("Вы попали к торговцу (будьте внимательны, он обвешивает)");
            System.out.println("1. Желаете купить зелье здоровья?");
            System.out.println("2. Желаете покинуть меня и вернуться к началу игры?");
            int command2 = scanner.nextInt();
            if (command2 == 1) {
                System.out.println("Вы купили зелье здоровья и теперь здоровье полностью восстановлено!");
                Player.buy();
                run();
            } else if (command2 == 2) {
                run();
            } else {
                System.out.println("Неверная команда. Начните заново!");
                run();
            }

        } else if (command == 3) {
            System.out.println("Игра окончена!");
        } else {
            System.out.println("Неверная команда. Начните заново!");
            run();
        }

    }

    public void start() {
        run();
    }
}
