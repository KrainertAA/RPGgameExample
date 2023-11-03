public class Player extends ParametersAndSkills {
    public Player(String name, int hp, int dex, int exp, int strength, int gold) {
        super(name, hp, dex, exp, strength, gold);
    }

    @Override
    public void attack() {
        System.out.println("Игрок " + this.getName() + " атакует!");
    }
}
