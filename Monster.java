public abstract class Monster implements Attack {
    private String name;
    private int hp;
    private int dex;
    private int exp;
    private int force;
    private int gold;

    public Monster(String name, int hp, int dex, int exp, int force, int gold) {
        this.name = name;
        this.hp = hp;
        this.dex = dex;
        this.exp = exp;
        this.force = force;
        this.gold = gold;
    }

    public int attack() {
        if (dex * 3 > getRandomValue()) return force;
        else return 0;
    }

    protected int getForce() {
        return force;
    }

    private int getRandomValue() {
        return (int) (Math.random() * 100);
    }

    static Monster createMonster() {
        int random = (int) (Math.random() * 10);
        if (random % 2 == 0) return new Goblin(
                "Гоблин",
                50,
                10,
                10,
                10,
                20
        );
        else return new Skeleton(
                "Скелет",
                25,
                20,
                20,
                10,
                10
        );
    }


    public String getName() {
        return name;
    }

    public int getHp() {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
