package src.Games;

import java.util.List;

import src.Model.Player;

public interface GameEvaluator {
    public Player evaluateWinner(List<Player> players);
    
}
