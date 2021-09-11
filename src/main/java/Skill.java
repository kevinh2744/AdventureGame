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

public class Skill {
    private String name;
    private int damage;
    private int manaCost;
    private String flavor;
    
    public Skill (String name, int damage, int manaCost, String flavor){
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
        this.flavor = flavor;
    }
    
    public String getSkillName(){
        return this.name;
    }
    
    public int getSkillDamage(){
        return this.damage;
    }
    
    public int getSkillManaCost(){
        return this.manaCost;
    }
    
    public String getSkillFlavor(){
        return this.flavor;
    }
    
    public String toString(){
        return this.name + " - deals " + this.damage + " damage, costs " + this.manaCost + " mana";
    }
}
