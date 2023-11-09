public class Goblin extends Monster implements Attack {


    public Goblin(String name, int hp, int dex, int exp, int force, int gold) {
        super(name, hp, dex, exp, force, gold);
    }

    @Override
    public void attack(Monster monster) {
        System.out.println(this.getName() + " атакует");
        monster.damage(getForce());
    }
}
