public abstract class ParametersAndSkills {
    private String name;
    private int hp;
    private int dex;
    private int exp;
    private int strength;
    private int gold;

    public ParametersAndSkills(String name, int hp, int dex, int exp, int strength, int gold) {
        this.name = name;
        this.hp = hp;
        this.dex = dex;
        this.exp = exp;
        this.strength = strength;
        this.gold = gold;
    }

    public abstract void attack ();

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

    public int getStrength() {
        return strength;
    }

    public int getGold() {
        return gold;
    }
}
