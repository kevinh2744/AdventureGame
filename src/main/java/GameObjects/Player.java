package GameObjects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */
import java.util.ArrayList;

public class Player implements java.io.Serializable {
    private int playerHealth;
    private int maxPlayerHealth;
    private int playerMana;
    private int maxPlayerMana;
    private ArrayList<Skill> skills;
    private int playerLevel;
    private int playerExperience;
    private int healthPotions;
    private int healthPotionHealAmount;
    
    public Player(){
        this.playerHealth = 100;
        this.maxPlayerHealth = 100;
        this.playerMana = 100;
        this.maxPlayerMana = 100;
        this.skills = new ArrayList<>();
        this.addSkill("Think", 50, 0, "You burn the enemy with the friction of rubbing two of your brain cells together");
        this.playerLevel = 1;
        this.playerExperience = 0;
        this.healthPotions = 3;
        this.healthPotionHealAmount = 30;
    }
    
    // returning player stats
    
    public int getPlayerHealth() {
        return this.playerHealth;
    }
    
    public int getMaxPlayerHealth(){
        return this.maxPlayerHealth;
    }
    
    public int getPlayerMana(){
        return this.playerMana;
    }
    
    public int getMaxPlayerMana(){
        return this.maxPlayerMana;
    }
    
    public int getPotionHealAmount(){
        return this.healthPotionHealAmount;
    }
    
    public int getPlayerLevel(){
        return this.playerLevel;
    }
    
    public int getPlayerExperience(){
        return this.playerExperience;
    }
    
    
    //setting and increasing stats
    
    public void setPlayerHealth(int amount){
        this.playerHealth = amount;
    }
    
    public void setPlayerMana(int amount){
        this.playerMana = amount;
    }
    
    public void restorePlayerHealth(int amount){
        this.playerHealth += amount;
        if (this.playerHealth >= this.maxPlayerHealth){
            this.playerHealth = this.maxPlayerHealth;
        }
    }
    
    public void restorePlayerMana(int amount){
        this.playerMana += amount;
        if (this.playerMana >= this.maxPlayerMana){
            this.playerMana = this.maxPlayerMana;
        }
    }
    
    public void setNumberOfPotions(int amount){
        this.healthPotions = amount;
    }
    
    
    //leveling and experience
    
    public void increaseLevel(){
        this.maxPlayerHealth += 25;
        setPlayerHealth(this.maxPlayerHealth);
        this.maxPlayerMana += 25;
        setPlayerMana(this.maxPlayerMana);
        this.healthPotionHealAmount += 10;
        this.healthPotions++;
        this.playerLevel ++;
        System.out.println("You are now level " + this.playerLevel + "!\n"
                + "Max health and mana have increased by 25, health and mana has been restored\n"
                + "Potion healing amount increased by 10, you have been given an additional potion\n");
        if (this.playerLevel == 2){
            this.addSkill("Think really hard", 75, 50, "You feel some folds developing on your smooth brain, and dish out some serious knowledge on your enemy");
            System.out.println("You learned a new skill!\n");
        }
        if (this.playerLevel == 4){
            this.addSkill("5head moment", 150, 75, "You forehead expands and begins to glow as a result of the increased firing rate of your neurons. The light grows so intense that your enemy begins to melt in the face of your momentarily unparalleled cognitive abilities");
            System.out.println("You learned a new skill!\n");
        }
    }
    
    public void increaseExperience (int increase){
        this.playerExperience += increase;
        if (this.playerExperience >= 100){
            increaseLevel();
            this.playerExperience = this.playerExperience - 100;
        }
    }
    
    //skills
    
    public void addSkill(String name, int damage, int manaCost, String flavor){
        skills.add(new Skill(name, damage, manaCost, flavor));
    }
    
    public void printSkills(){
        System.out.println("Skills:");
        for (Skill skill: skills){
            System.out.println((skills.indexOf(skill) + 1) + ": " + skill);
        }
    }
    
    public ArrayList<Skill> getSkills(){
        return this.skills;
    }
    
    public boolean enoughMana(Skill skill){
        if (skill.getSkillManaCost() > this.playerMana){
            return false;
        }
        return true;
    }
    
    public void useSkill(Skill skill){
        this.playerMana -= skill.getSkillManaCost();
        System.out.println(skill.getSkillFlavor());
    }
    
    //other methods used in battle
    public void takeDamage(int damage){
        this.playerHealth -= damage;
    }
    
    public void usePotion(){
        if(this.healthPotions <= 0){
            System.out.println("Ruh roh, you've run out of potions");
        }else{
            restorePlayerHealth(this.healthPotionHealAmount);
            this.healthPotions--;
        }
    }
    

    
    @Override
    public String toString(){
        return "Current player status:\nLevel: " + this.playerLevel + ", exp: " + this.playerExperience + "/100"
                + "\nHealth: " + this.playerHealth + "/" + this.maxPlayerHealth + ", Mana: " + this.playerMana + "/" + this.maxPlayerMana
                + "\nPotions: " + this.healthPotions + " (heal " + this.healthPotionHealAmount + " health)";
    }
}
