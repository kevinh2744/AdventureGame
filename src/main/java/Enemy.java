/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */
public class Enemy {
    private String enemyName;
    private int enemyHealth;
    private int enemyDamage;
    private int experienceGiven;
    
    public Enemy(String name, int enemyHealth, int enemyDamage, int experienceGiven){
        this.enemyName = name;
        this.enemyHealth = enemyHealth;
        this.enemyDamage = enemyDamage;
        this.experienceGiven = experienceGiven;
    }
    
    public String getEnemyName(){
        return this.enemyName;
    }
    
    public int getEnemyHealth(){
        return this.enemyHealth;
    }
    
    public int getEnemyDamage(){
        return this.enemyDamage;
    }
    
    public int getExperienceGiven(){
        return this.experienceGiven;
    }
    
    public void takeDamage(int damage) {
        this.enemyHealth -= damage;
    }
    @Override
    public String toString(){
        return "Enemy: " + this.enemyName + "\n"
                + "Health: " + this.enemyHealth + ", Damage: " + this.enemyDamage;
    }
}
