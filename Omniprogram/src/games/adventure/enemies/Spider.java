package games.adventure.enemies;

import games.adventure.gui.BattleGUI;
import games.adventure.player.Player;

public class Spider extends Enemies
{
	String name = "Spider";
	public Spider(Player playerClass)
	{
		super(playerClass);
	}
	@Override
	public int getHealth() 
	{
		return health;
	}
	@Override
	public boolean determineHitChance(int enemyLevel) 
	{
		//WRONG Need to fix the logic. The value incrementing is going the wrong way.
		switch(enemyLevel)
		{
		case 1: chanceToHit = 75; break;
		
		case 2: chanceToHit = 65; break;
		
		case 3: chanceToHit = 55; break;
		
		case 4: chanceToHit = 45; break;
		
		case 5: chanceToHit = 35; break;
		
		case 6: chanceToHit = 25; break;
		
		case 7: chanceToHit = 15; break;
		
		case 8: chanceToHit = 5; break;
			
		case 9: chanceToHit = 0; break;
		
		default: chanceToHit = 100; break;
		}
		if(randomNum.nextInt() >= chanceToHit)
			attackBool = true;
		else
			attackBool = false;
		return attackBool;
	}
	@Override
	public int doDamage() 
	{
		return initialDamage;
	}
	@Override
	public void takeDamage(int attackDamage) 
	{
		health -= attackDamage;
		
		if(health < 0)
			health = 0;
	}
	@Override
	public void healEnemy(int healPoints) 
	{
		if(health > initialHealth)
			health = initialHealth;
		
		health -= healPoints;
	}
	public String getName()
	{
		return name;
	}
	/* (non-Javadoc)
	 * @see games.adventure.enemies.Enemies#getLevel()
	 */
	@Override
	public int getLevel() 
	{
		// TODO Auto-generated method stub
		return enemyLevel;
	}	
}
