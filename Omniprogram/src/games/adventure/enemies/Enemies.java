package games.adventure.enemies;

import java.util.ArrayList;
import java.util.Random;

import games.adventure.player.Player;

public abstract class Enemies 
{
	boolean attackBool;
	int health;
	int chanceToHit = 0;
	double healthMultiplier;
	int difficultyNumber;
	int enemyLevel = 1;
	int enemyDamage = 0;
	int healPoints = 0;
	int initialHealth = 100;
	int initialDamage = 10;
	
	Random randomNum = new Random();
	Player playerClass;
	ManageEnemies manageEnemies;

	//Defines the Enemy's initial health
	public Enemies(Player playerClass)
	{
		this.playerClass = playerClass;
		health = initialHealth;
	}
	public abstract boolean determineHitChance(int enemyLevel);
	public abstract int getHealth();
	public abstract int doDamage();
	public abstract void takeDamage(int attackDamage);
	public abstract void healEnemy(int healPoints);
	public abstract String getName();
	public abstract int getLevel();
}
