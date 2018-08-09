package start;
import java.util.Scanner;
import Ability.*;
/**
 * This class is used to implement the battle when player meet the monster.
 * @author RuotongXu QiChangZhou
 *
 */
public class Battle {
	private double attack;
	private double defense;
	private int roundr;
	private int roundl;
	int fighting = 0;
	Scanner sc = new Scanner(System.in);
	TwoWay twoway = new TwoWay();
	Smash smash = new Smash();
	Reversal reversal = new Reversal();
/**
 * This method is used to depend which ability player choose by recognize the input ability name.
 * Then call the method which is belong to that ability.
 * @param s
 * @param m
 * @param monster
 */
	private void skilldepender(String s,Map m,Monster monster) {
		if(s.equals("Attack With Hard")) {
			this.awh(m, monster);
		}
		else if(s.equals("Become Huge")) {
			this.bh(m,monster);
		}
		else if(s.equals("Huge Impact")) {
			this.hi(m, monster);
		}
		else if(s.equals("Leech Seed")) {
			this.ls(m, monster);
		}
		else if(s.equals("Reversal")) {
			this.rs(m,monster);
		}
		else if(s.equals("Smash")) {
			this.sm(m, monster);
		}
		else if(s.equals("Tackle")) {
			this.tk(m, monster);
		}
		else if(s.equals("TwoWay")) {
			this.tw(m, monster);
		}
	}
/**
 * This method is when the player use ability "attack with hard", 
 * this round the player will attack the monster and player will get a defense improved, then hit by the monster. 
 * (The ability pp will reduce and damage calculate in this method too.)
 * @param m
 * @param monster
 */
	private void awh(Map m,Monster monster) {
			for(Ability ability:m.p.ablist.getAbilitylist()) {
				if(ability.getName().toLowerCase().equals("attack with hard")){
					if (ability.getPp() > 0) {
					m.p.setTempattack(this.attack*ability.getStrength());
					this.defense = this.defense*ability.getdefenseboost();
					ability.setPp(ability.getPp()-1);
					System.out.println("You used the "+ability.getName());
					System.out.println("You feel your defense improve.");
					double damage1 = (m.p.getTempattack()-monster.getdefense());
					if(damage1 <= 0) {
						damage1 = 1;
					}
					monster.setHealth(monster.getHealth()-damage1);
					System.out.println("You have deal "+damage1+" to "+monster.getName());
					} else {
						System.out.println("You do not have enough pp!");
						sc.nextLine();
					}
					double damage2 = (monster.getAttack()-this.defense);
					if(damage2 <= 0) {
						damage2 = 1;
					}
					m.p.setHealth(m.p.getHealth()-damage2);
					System.out.println(monster.getName()+" deals you "+damage2+" damages!");
					System.out.println("Your heal is "+m.p.getHealth()+monster.getName()+"'s heal is "+monster.getHealth());
				}
			}
	}
/**
 * This method is when player use the ability "become huge",
 * this round player will increase the attack and defense, then hit by monster.
 * (The ability pp will reduce and damage calculate in this method too.)
 * @param m
 * @param monster
 */
	private void bh(Map m,Monster monster) {
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			if(ability.getName().toLowerCase().equals("become huge")) {
			  if (ability.getPp() > 0) {
				this.attack = this.attack*ability.getAttackboost();
				this.defense = this.defense*ability.getdefenseboost();
				ability.setPp(ability.getPp()-1);
				System.out.println("You used the "+ability.getName());
				System.out.println("You feel you attack and defense improve a lot.");
			  } else {
					System.out.println("You do not have enough pp!");
					sc.nextLine();
				}
				double damage2 = (monster.getAttack()-this.defense);
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				System.out.println(monster.getName()+" deals you "+damage2+" damages!");
				System.out.println("Your heal is "+m.p.getHealth()+monster.getName()+"'s heal is "+monster.getHealth());
		   }
		}
	}	
/**
 * This method is when the player use ability "huge impact",
 * This round player will attack to the monster, than hit by monster.
 *(The ability pp will reduce and damage calculate in this method too.)
 * @param m
 * @param monster
 */
	private void hi(Map m,Monster monster) {
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			 if(ability.getName().toLowerCase().equals("huge Impact")) {
				 if (ability.getPp() > 0) {
					m.p.setTempattack(m.p.getAttack()*ability.getStrength());
					ability.setPp(ability.getPp()-1);
					System.out.println("You used the "+ability.getName());
					double damage1 = (m.p.getTempattack()-monster.getdefense());
					if(damage1 <= 0) {
						damage1 = 1;
					}
					monster.setHealth(monster.getHealth()-damage1);
					System.out.println("You have deal "+damage1+" to "+monster.getName());
				 } else {
						System.out.println("You do not have enough pp!");
						sc.nextLine();
					}
					double damage2 = (monster.getAttack()-this.defense);
					if(damage2 <= 0) {
						damage2 = 1;
					}
					m.p.setHealth(m.p.getHealth()-damage2);
					System.out.println(monster.getName()+" deals you "+damage2+" damages!");
					System.out.println("Your heal is "+m.p.getHealth()+monster.getName()+"'s heal is "+monster.getHealth());
			 }
	    }
	}
/**
 * This method is used when player use ability "smash",
 * This round player will attack to the monster, than hit by monster.
 * (The ability pp will reduce and damage calculate in this method too.)
 * @param m
 * @param monster
 */
	private void sm(Map m,Monster monster) {
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			if (ability.getName().toLowerCase().equals("smash")) {
				if (ability.getPp() > 0) {
					m.p.setTempattack(attack * ability.getStrength());
					ability.setPp(ability.getPp() - 1);
					System.out.println("You used the " + ability.getName());
					double damage1 = (m.p.getTempattack() - monster.getdefense());
					if (damage1 <= 0) {
						damage1 = 1;
					}
					monster.setHealth(monster.getHealth() - damage1);
					System.out.println("You have deal " + damage1 + " to " + monster.getName());
				} else {
					System.out.println("You do not have enough pp!");
					sc.nextLine();
				}
				double damage2 = (monster.getAttack()-this.defense);
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				System.out.println(monster.getName()+" deals you "+damage2+" damages!");
				System.out.println("Your heal is "+m.p.getHealth()+monster.getName()+"'s heal is "+monster.getHealth());
			}
		}
	}
/**
 * This method is used when player use ability "tackle",
 *  This round player will attack to the monster, than hit by monster.
 *  (The ability pp will reduce and damage calculate in this method too.)	
 * @param m
 * @param monster
 */
	private void tk(Map m,Monster monster) {
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			if(ability.getName().toLowerCase().equals("tackle")) {
				if (ability.getPp() > 0) {
				m.p.setTempattack(attack*ability.getStrength());
				ability.setPp(ability.getPp()-1);
				System.out.println("You used the "+ability.getName());
				double damage1 = (m.p.getTempattack()-monster.getdefense());
				if(damage1 <= 0) {
					damage1 = 1;
				}
				monster.setHealth(monster.getHealth()-damage1);
				System.out.println("You have deal "+damage1+" to "+monster.getName());
				} else {
					System.out.println("You do not have enough pp!");
					sc.nextLine();
				}
				double damage2 = (monster.getAttack()-this.defense);
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				System.out.println(monster.getName()+" deals you "+damage2+" damages!");
				System.out.println("Your heal is "+m.p.getHealth()+monster.getName()+"'s heal is "+monster.getHealth());
			}
		}
	}
/**
 * This method is used when the player use ability "reversal",
 * Player will heal up 1/3 heal for 3 times after the damage calculation turn by using while loop.
 * @param m
 * @param monster
 */
	private void rs(Map m, Monster monster) {
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			if(ability.getName().toLowerCase().equals("reversal")) {
				if (ability.getPp() > 0) {
				this.roundr = 3;
				ability.setPp(ability.getPp()-1);
				System.out.println("You feel you are full of healing power.");
				double damage2 = (monster.getAttack()-this.defense);
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				System.out.println(monster.getName()+" deals you "+damage2+" damages!");
				System.out.println(monster.getName()+"'s heal is "+monster.getHealth());
				m.p.setHealth(m.p.getHealth()+m.p.getHealthmax()*ability.getHealupbyp());
				System.out.println("You heal up "+m.p.getHealthmax()*ability.getHealupbyp()+" due to reversal");
				System.out.println("Your heal is "+m.p.getHealth()+m.p.getHealthmax()*ability.getHealupbyp());
				this.roundr = 2;
				while(this.roundr!=0) {
					this.typedepender(m, monster);
					m.p.setHealth(m.p.getHealth()+m.p.getHealthmax()*ability.getHealupbyp());
					System.out.println("Due to the Reversal you get "+m.p.getHealthmax()*ability.getHealupbyp()+" heals");
					System.out.println("Now you heal is "+m.p.getHealth());
					this.roundr--;
					if(monster.getHealth() <= 0) {
						this.roundr=0;
					}
					if(this.fighting == 1) {
						this.roundr = 0;
					}
				}
				System.out.println("Reversal effect disappear.");
				} else {
					System.out.println("Sorry you have not enough pp");
					sc.nextLine();
					double damage2 = (monster.getAttack()-this.defense);
					if(damage2 <= 0) {
						damage2 = 1;
					}
					m.p.setHealth(m.p.getHealth()-damage2);
					System.out.println(monster.getName()+" deals you "+damage2+" damages!");
					System.out.println("Your heal is "+m.p.getHealth()+monster.getName()+"'s heal is "+monster.getHealth());
				}
			}
		}
	}
/**
 * This method is used when the player use ability "leech seed",
 * the monster will reduce some heal and player will heal the same value for 3 rounds after damage calculation turn,
 * which is the same way to implement compare with "reversal".
 * @param m
 * @param monster
 */
	private void ls(Map m, Monster monster) {
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			if(ability.getName().toLowerCase().equals("leech seed")) {
				if (ability.getPp() > 0) {
				this.roundl = 3;
				ability.setPp(ability.getPp()-1);
				System.out.println("Enemy got the leechseed and keep losing heal, you are healed by seed.");
				double damage2 = (monster.getAttack()-this.defense);
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				System.out.println(monster.getName()+" deals you "+damage2+" damages!");
				monster.setHealth(monster.getHealth()-monster.getHealthmax()*ability.getPercentagehit());
				m.p.setHealth(m.p.getHealth()+monster.getHealthmax()*ability.getPercentagehit());
				this.roundl = 2;
				System.out.println("Due to the Leech Seed enemy gets "+monster.getHealthmax()*ability.getPercentagehit()+" damages.");
				System.out.println("And due to the Leech Seed you get "+monster.getHealthmax()*ability.getPercentagehit()+" heals.");
				System.out.println("Now you heal is "+m.p.getHealth());
				System.out.println(monster.getName()+"'s heal is "+monster.getHealth());
				this.roundl = 2;
				while(this.roundl!=0) {
					this.typedepender(m, monster);
					monster.setHealth(monster.getHealth()-monster.getHealthmax()*ability.getPercentagehit());
					m.p.setHealth(m.p.getHealth()+monster.getHealthmax()*ability.getPercentagehit());
					System.out.println("Due to the Leech Seed enemy gets "+monster.getHealthmax()*ability.getPercentagehit()+" damages.");
					System.out.println("And due to the Leech Seed you get "+monster.getHealthmax()*ability.getPercentagehit()+" heals.");
					System.out.println("Now you heal is "+m.p.getHealth());
					System.out.println(monster.getName()+"'s heal is "+monster.getHealth());
					this.roundl--;
					if(monster.getHealth() <= 0) {
						this.roundl=0;
					}
					if(this.fighting == 1) {
						this.roundl = 0;
					}
				}
				System.out.println("Leech Seed effect disappear.");
				} else {
					System.out.println("Sorry you have not enough pp");
					sc.nextLine();
					double damage2 = (monster.getAttack()-this.defense);
					if(damage2 <= 0) {
						damage2 = 1;
					}
					m.p.setHealth(m.p.getHealth()-damage2);
					System.out.println(monster.getName()+" deals you "+damage2+" damages!");
					System.out.println("Your heal is "+m.p.getHealth()+monster.getName()+"'s heal is "+monster.getHealth());
				}
			}
		}
	}
/**
 * This method is used when player use ability "two way",
 * this round player will increase the attack and defense, then hit by monster.
 * (The ability pp will reduce and damage calculate in this method too.)
 * @param m
 * @param monster
 */
	private void tw(Map m,Monster monster) {
		for(Ability ability:m.p.ablist.getAbilitylist()) {
			if(ability.getName().toLowerCase().equals("twoway")) {
				if (ability.getPp() > 0) {
				this.attack = this.attack*ability.getAttackboost();
				this.defense = this.defense*ability.getdefenseboost();
				ability.setPp(ability.getPp()-1);
				System.out.println("You used the "+ability.getName());
				System.out.println("You feel you attack and defense improved.");
				} else {
					System.out.println("You do not have enough pp!");
					sc.nextLine();
				}
				double damage2 = (monster.getAttack()-this.defense);
				if(damage2 <= 0) {
					damage2 = 1;
				}
				m.p.setHealth(m.p.getHealth()-damage2);
				System.out.println(monster.getName()+" deals you "+damage2+" damages!");
				System.out.println("Your heal is "+m.p.getHealth()+monster.getName()+"'s heal is "+monster.getHealth());
		   }
		}
	}
/**
 * This method is when player choose to use ability when fighting with monster
 * It will display the ability list of player by calling the play ability display class,
 * then use the skilldepender to depend which ability player type in to use.
 * it also depends the battle progress is over or not by conform the health of player and monster.
 * @param m
 * @param monster
 */
	private void battle(Map m,Monster monster) {
		int temp =0;
    	    System.out.println("Please select your ability to attack. Type 1, 2, 3 or 4 to select.");
    	    PlayerAbilityDisplay pad = new PlayerAbilityDisplay(m.p.ablist);
    	    int order = sc.nextInt();
    	    String s = m.p.ablist.getAbilitylist()[order-1].getName();
    	    this.skilldepender(s, m, monster);
    	    if(m.p.getHealth() <= 0) {
    	    	m.p.setRow(9);
    	    	m.p.setColumn(8);
    	    	m.p.setMoney(m.p.getMoney()/2);
    	    	m.p.setHealth(m.p.getHealthmax());
    	    	for (int i = 0; i < m.p.ablist.getTotalnumber(); i++) {
					m.p.ablist.getAbilitylist()[i].setPp(m.p.ablist.getAbilitylist()[i].getMaxpp());
				}
    	    	this.fighting =1;
    	    	System.out.println("You have been defeated!!");
    	    }
    	    if(monster.getHealth() <= 0) {
    	    	System.out.println("You have slain the monster! You have earned: "+monster.getMoney()+"$!");
    	    	if(monster.getHealthmax()==25) {
    	    		m.p.setM1defeat(true);
    	    	}
    	    	else if(monster.getHealthmax()==50) {
    	    		m.p.setM2defeat(true);
    	    	}
    	    	else if(monster.getHealthmax() == 90) {
    	    		m.p.setM3defeat(true);
    	    	}
    	    	else if(monster.getHealthmax() == 200) {
    	    		System.out.println("Now you save the small town! People are so happy that they won't suruand the demon!");
    	    		System.out.println("Congratuation and thank you for playing!");
    	    	}
    	    	m.p.setMoney(monster.getMoney()+m.p.getMoney());
    	    	
    	    	m.p.setExp(m.p.getExp()+monster.getExp());
    	    	if(m.p.getExp()>=10 && m.p.getExp()<30) {
    	    		m.p.setLevel(2);
    	    		m.p.setHealthmax(160);
    	    		m.p.setAttack(60);
    	    		m.p.setdefense(15);
    	    		System.out.println("Congrations! Level up! Your are lv2 now!");
    	    	}
    	    	else if(m.p.getExp()>=30 && m.p.getExp()<50) {
    	    		m.p.setLevel(3);
    	    		m.p.setHealthmax(170);
    	    		m.p.setAttack(70);
    	    		m.p.setdefense(20);
    	    		System.out.println("Congrations! Level up! Your are lv3 now!");
    	    		AbilityLimiter al = new AbilityLimiter(m.p.ablist);
    				if (!m.p.ablist.hasAbility(twoway) && al.isKeep() == false) {
    					if(al.AvoidDupulicate(m.p, twoway) == false) {
    					    m.p.ablist.addAbility(twoway);
    					}
    				}
    	    	}
    	    	else if(m.p.getExp()>=50 && m.p.getExp()<80) {
    	    		m.p.setLevel(4);
    	    		m.p.setHealthmax(180);
    	    		m.p.setAttack(80);
    	    		m.p.setdefense(25);
    	    		System.out.println("Congrations! Level up! Your are lv4 now!");
    	    	}
    	    	else if(m.p.getExp()>=80 && m.p.getExp()<120) {
    	    		m.p.setLevel(5);
    	    		m.p.setHealthmax(180);
    	    		m.p.setAttack(90);
    	    		m.p.setdefense(30);
    	    		System.out.println("Congrations! Level up! Your are lv5 now!");
    	    		AbilityLimiter al = new AbilityLimiter(m.p.ablist);
    				if (!m.p.ablist.hasAbility(smash) && al.isKeep() == false) {
    					if(al.AvoidDupulicate(m.p, smash) == false) {
    					    m.p.ablist.addAbility(smash);
    					}
    				}
    	    	}
    	    	else if(m.p.getExp()>=120 && m.p.getExp()<160) {
    	    		m.p.setLevel(6);
    	    		m.p.setHealthmax(185);
    	    		m.p.setAttack(95);
    	    		m.p.setdefense(35);
    	    		System.out.println("Congrations! Level up! Your are lv6 now!");
    	    	}
    	    	else if(m.p.getExp()>=160 && m.p.getExp()<200) {
    	    		m.p.setLevel(7);
    	    		m.p.setHealthmax(190);
    	    		m.p.setAttack(100);
    	    		m.p.setdefense(35);
    	    		System.out.println("Congrations! Level up! Your are lv7 now!");
    	    		AbilityLimiter al = new AbilityLimiter(m.p.ablist);
    				if (!m.p.ablist.hasAbility(reversal) && al.isKeep() == false) {
    					if(al.AvoidDupulicate(m.p, reversal) == false) {
    					    m.p.ablist.addAbility(reversal);
    					}
    				}
    	    	}
    	    	else if(m.p.getExp()>=200 && m.p.getExp()<250) {
    	    		m.p.setLevel(8);
    	    		m.p.setHealthmax(200);
    	    		m.p.setAttack(110);
    	    		m.p.setdefense(40);
    	    		System.out.println("Congrations! Level up! Your are lv8 now!");
    	    	}
    	    	else if(m.p.getExp()>=250 && m.p.getExp()<300) {
    	    		m.p.setLevel(9);
    	    		m.p.setHealthmax(210);
    	    		m.p.setAttack(120);
    	    		m.p.setdefense(45);
    	    		System.out.println("Congrations! Level up! Your are lv9 now!");
    	    	}
    	    	else if(m.p.getExp()>=300 && m.p.getExp()<384) {
    	    		m.p.setLevel(10);
    	    		m.p.setHealthmax(220);
    	    		m.p.setAttack(130);
    	    		m.p.setdefense(50);
    	    		System.out.println("Congrations! Level up! Your are lv10 now!");
    	    	}
    	    	this.fighting =1;
    	    	m.p.setColumn(5);
    	    	m.p.setRow(5);
    	    	}	
    	 }
/**
 * This method is used to decide which thing player want to do when fight with the monster by using switch case,
 * if the input is invalid, player escape.
 * @param m
 * @param monster
 */
	private void typedepender(Map m,Monster monster) {
		int order = 3;
		System.out.println("Please decide what you want to do: (Type the number)");
	    	System.out.println("1.Battle");
	    	System.out.println("2.Bag");
	    	System.out.println("3.Run");
	    	try {
	    	     order = sc.nextInt();
	    	     switch(order) {
	    	     case 1:
	    	    	 this.battle(m,monster);
	    	    	 break;
				 case 2:
					 UsingEntity ue = new UsingEntity(m.p);
	    	    	 double damage2 = (monster.getAttack()-this.defense);
						if(damage2 <= 0) {
							damage2 = 1;
						}
						m.p.setHealth(m.p.getHealth()-damage2);
						System.out.println(monster.getName()+" deals you "+damage2+" damages!");
						System.out.println("Your heal is "+m.p.getHealth()+monster.getName()+"'s heal is "+monster.getHealth());
						break;
	    	     case 3:
	    	    	 System.out.println("You escape from " +monster.getName());
	    	    	 fighting = 1;
	    	    	 break;
	    	     }
	    	}catch(Exception e) {
	    		System.out.println("Input invalid, you will be kicked out!");
	    		this.fighting =1;
	    	}
	}
/**
 * This is a constructor. When player meet a monster, it will give the initial value to attack and defense of player for the battle
 * it will keep looping order input if the battle is not over(player or monster dead or player escape)by using the do while loop.
 * @param m
 * @param monster
 */
	public Battle(Map m,Monster monster) {	
		this.attack = m.p.getAttack();
		this.defense = m.p.getdefense();
		System.out.println(m.p.getName()+" you meet a "+monster.getName()+"!");
		do {
    	    this.typedepender(m, monster);
		} while(fighting == 0);
	}
}
