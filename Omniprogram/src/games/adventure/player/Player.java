package games.adventure.player;

import java.util.Random;

import javax.swing.JOptionPane;

import games.adventure.enemies.Enemies;

/**To do:
 * Add while loop to allow user to go back to previous screen
 * Add graphics for each character
 * Add random name generator
 * Add difficulty scaling
 * Add save data
 * Finish commenting code
 * Solve suppressed warnings annotations
 * Add tooltips
 * 
 * @version 0.1
 * @author Jackson Murrell
 * @author J. L. Finley
 */
public class Player 
{
	final byte BASE_GOLD_GAIN = 10;
	final byte BASE_HEALTH = 50;
	final byte BASE_XP_GAIN = 50;
	final short MAX_HEALTH;
	final short MAX_MANA = 100;
	private int difficultyNumber;
	final byte MIN_HEALTH = 0;
	final byte MIN_MANA = 0;
	public String playerName;
	public String playerClass;
	public String difficultyName;
	private byte chanceOfAttack;
	private int initialAttackDamage;
	private int experience;
	private final byte BASIC_ATTACK = 10;
	private final byte HEAVY_ATTACK = 50;
	private final byte PERCENT = 100;

	Random randomNum = new Random();
	private int health;
	private int armor = 1;
	private int damageModifier = 1;
	
	public Player(int difficultyNumber, String difficultyName, String name, String className)
	{
		this.difficultyNumber = difficultyNumber;
		MAX_HEALTH = (short) (BASE_HEALTH * difficultyNumber);
		playerName = name;
		playerClass = className;
		this.difficultyName = difficultyName;
		experience = 0;
		health = MAX_HEALTH;
	}
	public String getPlayerName()
	{
		return playerName;
	}
	public String getPlayerClass()
	{
		return playerClass;
	}
	public int getMAX_HEALTH()
	{
		return MAX_HEALTH;
	}
	public int damagePlayer(int incomingDamage)
	{
		int damage = (incomingDamage/armor)*damageModifier;
		
		health -= damage;
		
		if(health < 0)
			health = 0;
		
		return damage;
	}
	public int getHealth()
	{
		return health;
	}
	public int healPlayer(int regen, int health)
	{
		health += regen;
		
		if(health > MAX_HEALTH)
			health = MAX_HEALTH;
		
		return health;
	}
	public int getMAX_MANA()
	{
		return MAX_MANA;
	}
	public int getDifficultyNumber()
	{
		return difficultyNumber;
	}
	//This method determines how much damage a basic attack does.
	public int basicAttack()
	{
		initialAttackDamage = randomNum.nextInt(BASIC_ATTACK);
		
		initialAttackDamage++;
		
		//This makes the player's damage increase with their level.
		initialAttackDamage *= getLevel();
		
		return initialAttackDamage;
	}
	//This method determines how much damage a heavy attack does, and if it hits.
	public int heavyAttack()
	{
		
		chanceOfAttack = (byte)randomNum.nextInt(PERCENT);
	
		chanceOfAttack++;
	
		//For bug testing only
		System.out.println("Percentage chance to hit: " + chanceOfAttack);
	
		//A 50% to hit.
		if (chanceOfAttack >= 50)
		{
			initialAttackDamage = randomNum.nextInt(HEAVY_ATTACK);
			
			initialAttackDamage++;
			
			//This makes the player's damage increase with their level.
			initialAttackDamage *= getLevel();
			
			return initialAttackDamage;
		}
		else
		{
			//The player missed so their attack damage is zero.
			initialAttackDamage = 0;
			
			JOptionPane.showMessageDialog(null,"Your attack missed.");
		
			return initialAttackDamage;
		}
	}
	public int getLevel()
	{
		return 1;
	}
	public int getXPGain(Enemies currentEnemy)
	{
		return getXPModifier()*((BASE_XP_GAIN*currentEnemy.getLevel()));
	}
	/**
	 * @return
	 * @return int
	 */
	public int getXPModifier() 
	{
		return 1;
	}
	/**
	 * @return int
	 */
	public int getCurrentXP() 
	{
		return experience;
	}
	/**
	 * @param currentEnemy
	 * @return String
	 */
	public int getGoldGain(Enemies currentEnemy) 
	{
		return getGoldModifier()*((BASE_GOLD_GAIN*currentEnemy.getLevel()));
	}
	/**
	 * @return int
	 */
	private int getGoldModifier() 
	{
		// TODO Auto-generated method stub
		return 1;
	}
}