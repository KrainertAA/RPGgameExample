import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в наш мир! Куда желаете пойти?");
        Battle battle = new Battle();
        battle.add(new Goblin("Гоблин", 30, 10, 50, 10, 100));
        battle.add(new Skeleton("Скелет", 40, 5, 50, 8, 100));
        battle.add(new Player("Игорь", 100, 20, 0, 20, 0, 1));

        battle.start();

    }
}
