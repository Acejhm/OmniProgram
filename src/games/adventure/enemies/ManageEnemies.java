package games.adventure.enemies;

import java.util.ArrayList;
import java.util.Random;

import games.adventure.player.Player;

public class ManageEnemies 
{
	byte temp = 0;
	int enemyHealth;
	int chanceToHit = 0;
	double healthMultiplier;
	int difficultyNumber;
	int enemyLevel = 1;
	int enemyDamage = 0;
	int healPoints = 0;
	int initialEnemyHealth = 100;
	int intialEnemyDamage = 10;
	int playerHealth;
	
	ArrayList enemiesArray = new ArrayList();
	
	Random randomNum = new Random();
	Object currentEnemy;
	
	Player playerClass;
	//Defines the Enemy's initial health
	public ManageEnemies(Player playerClass)
	{
		this.playerClass = playerClass;
		difficultyNumber = this.playerClass.getDifficultyNumber();
		enemyHealth = initialEnemyHealth;	
		enemiesArray.add(new Spider(playerClass));
		enemiesArray.add(new Skeleton(playerClass));
		enemiesArray.add(new Zombie(playerClass));
		enemiesArray.add(new Knight(playerClass));
	}
	public Object randomizeEnemy()
	{	int num = randomNum.nextInt(enemiesArray.size());
		setCurrentEnemy(num);
		return enemiesArray.get(num);
	}
	private void setCurrentEnemy(int currentEnemy)
	{
		this.currentEnemy = enemiesArray.get(currentEnemy);
	}
	public int getEnemyHealth()
	{
		return ((Enemies) currentEnemy).getHealth();
	}
	public Object getCurrentEnemy()
	{
		//This line should be changed at some point.
		randomizeEnemy();
		return currentEnemy;
	}
	
	
	
}
