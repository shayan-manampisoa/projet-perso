package src.Games;

import src.Controller.GameController;
import src.Model.Deck;
import src.View.View;

public class Games {
    public static void main(String[] args) {
        GameController gc = new GameController(new Deck(), new View());
        gc.run();
    }
}
