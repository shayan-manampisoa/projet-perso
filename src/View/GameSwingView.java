package src.View;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import src.Controller.GameController;

public class GameSwingView implements GameViewable {
    GameController controller;
    JTextArea textArea;
    JFrame frame;

    public void createAndShowGUI() {

        //create main frame
        frame = new JFrame("MVC-SOLID-Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        //display vertically
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        addControllerCommandTracker(contentPane);

        frame.setVisible(true);

    }

    private void addControllerCommandTracker(Container contentPane) {
        textArea = new JTextArea("Game Status\n", 100,1);
        JScrollPane scrollPane = new JScrollPane(textArea);
        addCenteredComponent(scrollPane, contentPane);
        textArea.setSize(500, 500);
    }

    private void addCenteredComponent(JScrollPane component, Container contentPane) {
        component.setAlignmentX(Container.CENTER_ALIGNMENT);
        contentPane.add(component);
    }

    private void appendText(String text) {
        textArea.append(text + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    @Override
    public void setController(GameController controller) {
        this.controller = controller;
    }
    @Override
    public void promptForPlayerName() {
        String result = (String) JOptionPane.showInputDialog(frame, "Add a player", "Player", JOptionPane.PLAIN_MESSAGE, null, null, "");

        if ( result == null || result.isEmpty()){
            controller.nextAction("+q");
        }

        controller.addPlayer(result);

        int addMore = JOptionPane.showConfirmDialog(frame, "Add another player?", "More Players", JOptionPane.YES_NO_OPTION);

        if( addMore == JOptionPane.NO_OPTION) {
            controller.startGame();
        }
    }
    @Override
    public void promptForFlip() {
        controller.flipCards();
    }
    @Override
    public void promptForNewGame() {
        int newGame = JOptionPane.showConfirmDialog(frame, "Play again?", "Play again", JOptionPane.YES_NO_OPTION);
        controller.nextAction(newGame == JOptionPane.NO_OPTION ? "+q" : "");
    }
    @Override
    public void showWinner(String playerName) {
        appendText("Winner!\n: " + playerName);
    }
    @Override
    public void showPlayerName(int playerIndex, String playerName) {
    appendText("[" + playerIndex + "] [" + playerName +"]");
    }
    @Override
    public void showfaceDowncardForPlayer(int playerIndex, String playerName) {
        appendText("[" + playerName + "][][]");
    }
    @Override
    public void showcardForPlayer(int playerIndex, String playerName, String rank, String suit) {
        appendText("[" + playerName + "][" + rank + ":" + suit + "]");
    }
    
}
