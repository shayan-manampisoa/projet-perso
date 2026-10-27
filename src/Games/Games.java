package src.Games;

import src.Controller.GameController;
import src.Model.Deck;
import src.View.GameSwingView;

public class Games {
    public static void main(String[] args) {
        //GameController gc = new GameController(new Deck(), new View(), new HighCardGameEvaluator());
        GameSwingView gsv = new GameSwingView();
        gsv.createAndShowGUI();
        GameController gc = new GameController(new Deck(), gsv, new LowCardGameEvaluator());

        gc.run();
    }
}
