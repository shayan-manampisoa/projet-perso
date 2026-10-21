package src.View;

import java.util.Scanner;

import src.Controller.GameController;

public class View {
    GameController controller;
    Scanner keyboard = new Scanner(System.in);

    public void setController(GameController gc){
        this.controller = gc;
    };

    public void promptForPlayerName(){
        System.out.print("Enter player name: ");
        String name = keyboard.nextLine();
        if(name.isEmpty()){
            controller.startGame();
        }
        else{
            controller.addPlayer(name);
        }
    };

    public void promptForFlip(){
        System.err.println("Press enter to reveal cards");
        keyboard.nextLine();
        controller.flipCards();
    };

    public void promptForNewGame(){
        System.out.println("Press enter to deal again");
        keyboard.nextLine();
        controller.startGame();
    };

    public void showPlayerName(int playerIndex, String playerName){
        System.out.println("[" + playerIndex + "][" + playerName + "]");
    };

    public void showfaceDowncardForPlayer(int playerIndex, String playerName){
        System.out.println("[" + playerIndex + "][" + playerName + "][x][x]");
    };

    public void showcardForPlayer(int i, String playerName, String rank, String suit){
        System.out.println("[" + i + "][" + playerName + "][" + rank + "][" + suit + "]");
    }

    public void showWinner(String playerName){
        System.out.println("Winner is: " + playerName);
    };

}
