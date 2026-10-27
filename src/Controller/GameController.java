package src.Controller;

import java.util.ArrayList;
import java.util.List;

import src.Games.GameEvaluator;
import src.Model.Deck;
import src.Model.Player;
import src.Model.PlayingCard;
import src.View.GameViewable;


public class GameController {

    enum GameState {
        AddingPlayers,
        CardsDealt,
        WinnerRevealed;
    }

    Deck deck;
    List<Player> players;
    Player winner;
    GameViewable view;
    GameState gameState;

    GameEvaluator evaluator;

    public GameController(Deck deck, GameViewable view, GameEvaluator evaluator) {
        super();
        this.deck = deck;
        this.view = view;
        this.players = new ArrayList<Player>();
        view.setController(this);
        this.gameState = GameState.AddingPlayers;
        this.evaluator = evaluator;
    }

    public void run() {
        while(gameState == GameState.AddingPlayers) {
            view.promptForPlayerName();
        }
        switch(gameState) {
            case CardsDealt:
                view.promptForFlip();
                break;
            case WinnerRevealed:
                view.promptForNewGame();
                break;
            default:
                break;
        }
    }

    public void addPlayer(String playerName){
        if(gameState == GameState.AddingPlayers) {
            players.add(new Player(playerName));
            view.showPlayerName(players.size(),playerName);
        }
    }

    public void startGame() {
        if(gameState != GameState.CardsDealt) {
            deck.shuffle();
            int playerIndex = 1;

            for(Player player : players) {
                player.addCardToHand(deck.removeTopCard());
                view.showfaceDowncardForPlayer(playerIndex++,player.getName());
            }
            gameState = GameState.CardsDealt;
        }
        this.run();
    }

    public void flipCards(){
        int playerIndex = 1;

        for(Player player : players){
            PlayingCard pc = player.getCard(0);
            pc.flip();
            view.showcardForPlayer(playerIndex++,player.getName(), pc.getRank().toString(), pc.getSuit().toString());
        }

        evaluateWinner();
        displayWinner();
        rebuiltDeck();
        gameState = GameState.WinnerRevealed;
        this.run();
    }

    void evaluateWinner() {
        winner = evaluator.evaluateWinner(players);
        
    }

    void displayWinner() {
        view.showWinner(winner.getName());
    }

    void rebuiltDeck() {
        for(Player player : players) {
            deck.returnCardToDeck(player.removeCard());
        }
    }

    void exitGame() {
        System.exit(0);
    }

    public void nextAction(String nextChoice) {
        if("+q".equals(nextChoice)){
            exitGame();
        }
        else{
            startGame();
        }
    }
}
