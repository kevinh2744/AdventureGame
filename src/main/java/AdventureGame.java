/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import Game.Game;
import java.io.IOException;
import java.util.Scanner;

public class AdventureGame {

    /**
     * @param args the command line arguments
     */
    static Game game;
    public static void main(String[] args) throws IOException{
        game = new Game();
        Scanner scanner = new Scanner(System.in);
        
        //asking to load saved game
        while (true){
            System.out.println("If you have a saved game you would like to play, please type load. Otherwise, type y to begin the game");
            String input = scanner.nextLine();
            input = cleanString(input);
            if (input.equals("load")){
                loadGame();
                break;
            }else if (input.equals("y")){
                break;
            }else{
                System.out.println("Input not recognized, please try again");
            }
        }
        
        //game starts at introduction or at place game was saved
        while (true){
            if (game.getGameProgress() == 0){
                game.introduction();
                game.initiateFirstBattle();
                askSave();
            }else if(game.getGameProgress() == 1){
                game.initiateSecondBattle();
                askSave();
            }else if(game.getGameProgress() == 2){
                game.initiateThirdBattle();
                askSave();
            }else if(game.getGameProgress() == 3){
                game.initiateFourthBattle();
                askSave();
            }else if(game.getGameProgress() == 4){
                game.initiateFinalBattle();
            }else if(game.getGameProgress() == 5){
                game.ending();
            }
        }

    }
    
    //methods for saving and loading
    private static void saveGame(){
        try{
            FileOutputStream fos = new FileOutputStream("save");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(game);
            oos.flush();
            oos.close();
            System.out.println("Game saved");
        }catch(Exception e){
            System.out.println("Something went wrong saving your game!\n" 
            + e.getClass() + ": " + e.getMessage());
        }
    }
    
    private static void loadGame(){
        try{
            FileInputStream fis = new FileInputStream("save");
            ObjectInputStream ois = new ObjectInputStream(fis);
            game = (Game) ois.readObject();
            System.out.println("Game loaded");
        }catch(Exception e) {
            System.out.println("Something went wrong with loading your game!\n"
            + e.getClass() + ": " + e.getMessage());
        }
    }
    
    public static void askSave(){
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.println("Would you like to save your game? Type y to do so, type n to continue");
            String input = scan.nextLine();
            input = cleanString(input);
            if (input.equals("y")){
                saveGame();
                break;
            }else if(input.equals("n")){
                break;
            }else{
                System.out.println("Command not recognized, please try again");
            }
        }
        
    }
    
    //to make stuff pretty
    public static String cleanString(String string) {
        if (string == null) {
            return "";
        }
        string = string.toLowerCase();
        return string.trim();
    }

}
