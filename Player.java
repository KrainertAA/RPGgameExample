public class Player extends Monster implements Attack {
    private int level;

    public Player(String name, int hp, int dex, int exp, int force, int gold, int level) {
        super(name, hp, dex, exp, force, gold);
        this.level = level;
    }


    @Override
    public void attack(Monster monster) {
        System.out.println("Игрок " + this.getName() + " атакует");
        monster.damage(getForce());
    }

    public int getLevel() {
        return level;
    }

    public static int buy() {
        if (getHp() == 100) {
            return getHp();
        } else if (getHp() > 100) {
            return 100;
        } else
            return getHp() + Trader.healthPotion;
    }

}
