/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */
import java.util.Scanner;

public class Battle {
    private Enemy enemy;
    private Player player;
    
    public Battle(Player player, Enemy enemy){
        this.enemy = enemy;
        this.player = player;
    }
    
    public boolean start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nYou have encountered a " + this.enemy.getEnemyName() + "!");
        while (true){
            System.out.println("\n" + this.enemy + "\n");
            System.out.println(this.player + "\n");
            System.out.println("What would you like to do?");
            System.out.println("1: Attack");
            System.out.println("2: Use Potion (does not consume turn)");
            System.out.println("3: Cry.");
            
            int selection = Integer.valueOf(scanner.nextLine());
            if (selection == 1){
                int damageDealt = 0;
                outerloop:
                while (true) {
                    this.player.printSkills();
                    int skillNumber = Integer.valueOf(scanner.nextLine());
                    for (Skill skill: this.player.getSkills()){
                        if ((skillNumber - 1) == this.player.getSkills().indexOf(skill)){
                            if (this.player.enoughMana(skill)){
                                this.enemy.takeDamage(skill.getSkillDamage());
                                damageDealt = skill.getSkillDamage();
                                this.player.useSkill(skill);
                                break outerloop;
                            }else{
                                System.out.println("Not enough mana, please choose another attack");
                            }
                        }
                    }
                }
                System.out.println("You have dealt " + damageDealt + " damage to the enemy");
            }else if(selection == 2){
                this.player.usePotion();
                System.out.println("You have restored " + this.player.getPotionHealAmount() + " health");
                continue;
            }else if(selection == 3){
                System.out.println("These problems ain't gonna solve themselves");
            }else{
                System.out.println("Command not recognized, please try again");
                continue;
            }
            
            if(this.enemy.getEnemyHealth() <= 0){
                System.out.println("You have defeated the enemy!\n"
                        + "Experience gained: " + this.enemy.getExperienceGiven());
                System.out.println("_________________________________________________________");
                this.player.increaseExperience(this.enemy.getExperienceGiven());
                this.player.increaseGameProgression();
                return false;
            }
            
            this.player.takeDamage(this.enemy.getEnemyDamage());
            System.out.println("Enemy has dealt " + this.enemy.getEnemyDamage() + " damage to you");
            
            if (this.player.getPlayerHealth() <= 0){
                System.out.println("You just got a big fat 0, no way you're passing this class. I'll see you next semester :^)");
                return true;
            }
        }
    }
}
