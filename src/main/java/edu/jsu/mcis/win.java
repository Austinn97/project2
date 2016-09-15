package edu.jsu.mcis;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author 2015a_000
 */
public class win {
    public boolean gameFinished;
    private JButton winButton[];
    
    public win(boolean getGameFinished, JButton getWinButton[]){
        winButton = getWinButton;
        gameFinished = getGameFinished;
        
    }
    public boolean winner(){
    for(int i=1; i<=7; i++){
        if (gameFinished == false){
            if (i == 1) {
                    
                    whoWon(i, i + 4, i + 8);
                }
                if (i <= 3) {
                    
                    whoWon(i, i + 3, i + 6);
                }
                if (i == 1 || i == 4 || i == 7) {
                    
                    whoWon(i, i + 1, i + 2);
                }
                if (i == 3) {
                  
                    whoWon(i, i + 2, i + 4);
                }
        }
        }
    return gameFinished;
    }
    
	
    public void whoWon(int a, int b, int c){
        if (winButton[a].getText().equals("X")) {
            if (winButton[b].getText().equals("X")) {
                if (winButton[c].getText().equals("X")) {
                    showWinner("X");
                }
            }
        }
       
        if (winButton[a].getText().equals("O")) {
            if (winButton[b].getText().equals("O")) {
                if (winButton[c].getText().equals("O")) {
                    showWinner("O");
                }
            }
        }
    }
    public void showWinner(String xoWin){
        if (gameFinished == false) {
            JOptionPane.showMessageDialog(null, xoWin + " wins!");
            for (int k=1; k<10; k++) {
                winButton[k].setEnabled(false);
            }
            gameFinished = true;

        }
 
   
}
    public void tie(){
        JOptionPane.showMessageDialog(null, "Tie!");
        gameFinished = true;

    }
    
    public void setToFalse(){
        gameFinished = false;
    }
    
   
    
    
}
  
    

