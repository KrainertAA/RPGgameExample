import java.util.Scanner;

public class Main {
    public static String namePlayer;

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в наш сказочный мир! Как вас зовут, доблестный рыцарь?");
        Scanner scanner2 = new Scanner(System.in);
        namePlayer = scanner2.nextLine();
        System.out.println("Куда желаете пойти, " + namePlayer + "?");
        Battle battle = new Battle();
        battle.helloInTheWorld();
        battle.start();


    }
}
