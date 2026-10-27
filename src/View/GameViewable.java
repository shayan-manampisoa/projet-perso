package src.View;

import src.Controller.GameController;

public interface GameViewable {
    public void setController(GameController gc);
    public void promptForPlayerName();
    public void promptForFlip();
    public void promptForNewGame();
    public void showWinner(String playerName);
    public void showPlayerName(int playerIndex, String playerName);
    public void showfaceDowncardForPlayer(int playerIndex, String playerName);
    public void showcardForPlayer(int playerIndex, String playerName, String rank, String suit);
}
