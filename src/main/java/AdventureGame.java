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
import java.util.ArrayList;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class AdventureGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // establishing player, enemies, and fights
        Player player = new Player();
        Enemy problemSet = new Enemy("Problem Set", 100, 25, 25);
        Enemy harderProblemSet = new Enemy("Harder Problem Set", 150, 50, 50);
        Enemy midterm = new Enemy("Midterm", 200, 65, 75);
        Enemy problemSet2 = new Enemy("Problem Set", 150, 50, 50);
        Enemy harderProblemSet2 = new Enemy("Harder Problem Set", 200, 65, 60);
        Enemy finalExam = new Enemy ("Final Exam", 325, 85, 0);
        
        Battle firstBattle = new Battle(player, problemSet);
        Battle secondBattle = new Battle(player, harderProblemSet);
        Battle thirdBattle = new Battle(player, midterm);
        Battle fourthBattle = new Battle(player, problemSet2);
        Battle fifthBattle = new Battle(player, harderProblemSet2);
        Battle finalBattle = new Battle(player, finalExam);
        
        
        // storyline starts
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Welcome to CIS 160! This will be a very challenging, yet rewarding course. I hope you'll survi- I mean thrive this semester");
            System.out.println("Are you ready to get started? Type y to continue");
            
            if (checkContinue()){
               break;
            }else{
                System.out.println("Command not recognized, please try again");
            }
        }
        // first battle: problem set!
        while(true){
            System.out.println("Great, let's go to our first class");
            System.out.println("Oh my good godness! A problem set on the first day of classes? I hope it's not too hard...");
            System.out.println("Are you ready to give it a go? Type y to continue");
            
            if (checkContinue()){
               break;
            }else{
                System.out.println("Command not recognized, please try again");
            }
        }
        
        if (firstBattle.start()){
            System.exit(0);
        }
        
        // second battle: harder problem set
        System.out.println("Whew, that wasn't so bad. Looks like you got some extra time before the next assignment is due. What would you like to do?");
        giveChoices(player);
        
        while (true){
            System.out.println("Looks like the deadline for the next problem set is coming up. This one looks a bit more tricky... are you ready? Type y to continue");
            if (checkContinue()){
                   break;
                }else{
                    System.out.println("Command not recognized, please try again");
                }
        }
        
        if (secondBattle.start()){
            System.exit(0);
        }
        
        //third battle: midterm
        System.out.println("Holy smokes this class is getting pretty hard. I think the midterm is coming up sometime soon... What you gonna do?");
        giveChoices(player);
        
        while (true){
            System.out.println("Wait, the midterm is today? I hope you studied... are you ready? Type y to continue");
            if (checkContinue()){
                break;
            }else{
                System.out.println("Command not recognized, please try again");
            }
        }
        if (thirdBattle.start()) {
            System.exit(0);
        }
        
        // fourth battle: problem set and hard problem set back to back
        System.out.println("Omg, I like, totally failed that test!! I can't even look at my grade, I'm so scar- oh I got a 94. Nice, looks like you passed too\n"
                + "Time for a short break, you deserve it. What would you like to do?");
        giveChoices(player);
        
        while (true){
            System.out.println("Looks like the next problem set is due. I haven't checked the schedule recently, I hope our workload isn't increasing... Type y to continue");
            if (checkContinue()) {
                break;
            } else {
                System.out.println("Command not recognized, please try again");
            }
        }
        if (fourthBattle.start()){
                System.exit(0);
            }
        
        while (true){
            System.out.println("Wait, the next problem set is due tomorrow? You knew that, right? Type y to continue");
            if (checkContinue()) {
                break;
            } else {
                System.out.println("Command not recognized, please try again");
            }
        }
        if (fifthBattle.start()) {
            System.exit(0);
        }
        
        //last battle: final exam
        System.out.println("Alrighty, one more test and then you'll never have to take this class again. How will you spend your reading week?");
        giveChoices(player);
        
        while (true){
            System.out.println("Home stretch. You ready? Type y to continue");
            if (checkContinue()) {
                break;
            } else {
                System.out.println("Command not recognized, please try again");
            }
        }
        if (finalBattle.start()) {
            System.exit(0);
        }
        
        System.out.println("Congrats! You have just passed one of the hardest courses at Penn. It gets easier from here right?");
    }
    
    
    public static String cleanString(String string) {
        if (string == null) {
            return "";
        }
        string = string.toLowerCase();
        return string.trim();
    }
    
    public static boolean checkContinue(){
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        command = cleanString(command);
        if (command.equals("y")) {
            return true;
        }
        return false;
    }
    
    public static void giveChoices(Player player){
        while (true){
            System.out.println("1: Do practice problems (increases experience by 25)");
            System.out.println("2: Eat and rest (restores 50 health and mana)");
            System.out.println("3: Stare at a wall for an unreasonably long time\n");
            System.out.println(player);
            Scanner scan = new Scanner(System.in);
            String choice = scan.nextLine();
            if (choice.equals("1")) {
                player.increaseExperience(25);
                System.out.println("Experience has increased by 25, current level: " + player.getPlayerLevel() + ", exp: " + player.getPlayerExperience() + "/100");
                System.out.println("_________________________________________________________");
                break;
            }else if (choice.equals("2")) {
                player.restorePlayerHealth(50);
                player.restorePlayerMana(50);
                System.out.println("Health and Mana have been restored by 50, current Health: " 
                        + player.getPlayerHealth() + "/" + player.getMaxPlayerHealth() 
                        + ", Mana: " + player.getPlayerMana() + "/" + player.getMaxPlayerMana());
                System.out.println("_________________________________________________________");
                break;
            }else if (choice.equals("3")) {
                System.out.println("Excellent choice.");
                System.out.println("_________________________________________________________");
                break;
            }else{
                System.out.println("Command not recognized, please try again");
            }
        }
    }
    
    private static void savePlayer(Player player){
        try{
            FileOutputStream fos = new FileOutputStream("save");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(player);
            oos.flush();
            oos.close();
            System.out.println("Game saved");
        }catch(Exception e){
            System.out.println("Something went wrong with your save point!");
        }
    }
    
    private static void loadPlayer(Player player){
        try{
            FileInputStream fis = new FileInputStream("save");
            ObjectInputStream ois = new ObjectInputStream(fis);
            player = (Player) ois.readObject();
            System.out.println("Game loaded");
        }catch(Exception e) {
            System.out.println("Something went wrong with your save point!");
        }
    }
    
    private static boolean initiateBattle(ArrayList<Battle> battles, int number){
        return battles.get(number).start();
    }
}
