package start;

public class LeechSeed extends Ability {
	private int money =200;
	public LeechSeed() {
		super("Leech Seed");
		super.setDescription("This ability can make the enemy keep losing max health 1/6 and heal your self for 3 round");
		super.setPercentagehit(0.16667);
		super.setPp(1);
	}
	public int getMoney() {
		return this.money;
	}
}
