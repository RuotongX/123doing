package Ability;
import start.*;
/**
 * This class is just give the basic value to this ability.
 * @author RuotongXu QiChangZhou
 *
 */
public class Smash extends Ability {
	public Smash() {
	   super("Smash");
	   super.setStrength(0.65);
	   super.setDescription("This is a epic attack ability which is used by a legendary hero.");
	   super.setMaxpp(7);
	   super.setPp(7);
	}
}
