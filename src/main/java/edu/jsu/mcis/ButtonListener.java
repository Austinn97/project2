package edu.jsu.mcis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonListener implements ActionListener {
    private TicTacToeVC myGui;
    
    public ButtonListener(TicTacToeVC getValues){
        myGui = getValues;
    }
    
  
    public void actionPerformed(ActionEvent event){
        win action = new win(myGui.getFinished(), myGui.getButton1());
        
        if (event.getActionCommand() == "Start"){
            for (int i=1; i<10; i++){
                myGui.getButton(i).setEnabled(true);
                myGui.getButton(i).setText("");
                myGui.setTurnX(true);
                myGui.getButton(0).setText("Turn: X");
                
            }
        
            myGui.setFinished(false);
            action.setToFalse();
            myGui.setSpacesLeft(9); }
            
            for (int i=1; i<10; i++){
                if (event.getSource().equals(myGui.getButton(i))){
                if (myGui.getTurnX()){
                    myGui.getButton(i).setText("X");
                    myGui.getButton(i).setEnabled(false);
                    myGui.SubtractSpacesLeft();
                    myGui.getButton(0).setText("Turn: O");
                    myGui.setTurnX(false);
                }
                else if (myGui.getTurnX() == false) {
                            myGui.getButton(i).setText("O");
                            myGui.getButton(i).setEnabled(false);
                            myGui.SubtractSpacesLeft();
                            myGui.setTurnX(true);
                            myGui.getButton(0).setText("Turn: X");
            }
          }    
            
        
            myGui.setFinished(action.winner()); // checking for win

            if (myGui.getSpacesLeft()== 0 && myGui.getFinished()== false) { 
                action.tie();
            }
            
            }
        
    }
}
    

