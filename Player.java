public class Player extends Monster implements Attack {
    private int level;

    public Player(String name, int hp, int dex, int exp, int force, int gold, int level) {
        super(name, hp, dex, exp, force, gold);
        this.level = level;
    }


    public int getLevel() {
        return level;
    }

}
