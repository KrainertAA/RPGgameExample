public abstract class Monster {
    private String name;
    private static int hp;
    private int dex;
    private int exp;
    private int force;
    private int gold;
    private boolean destroyed = false;

    public Monster(String name, int hp, int dex, int exp, int force, int gold) {
        this.name = name;
        this.hp = hp;
        this.dex = dex;
        this.exp = exp;
        this.force = force;
        this.gold = gold;
    }

    protected int getForce() {
        return force;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    protected boolean damage(int dhp) {
        hp -= dhp;
        if (hp < 0) {
            destroyed = true;
            System.out.println("Участник битвы " + name + " был уничтожен!");
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public static int getHp() {
        return hp;
    }

    public int getDex() {
        return dex;
    }

    public int getExp() {
        return exp;
    }

    public int getGold() {
        return gold;
    }
}
