package edu.jsu.mcis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 2015a_000
 */
public class TicTacToeVC {
    private JFrame frame;
    private JPanel Grid, Turn;
    private JButton buttons[], start;
    private boolean xoTurn, gameOver;
    private int spacesLeft, player;
    private ButtonListener event;
    
    
    public TicTacToeVC() {
        frame = new JFrame ("Tic Tac Toe");
        
        Grid = new JPanel();
        Turn = new JPanel();
        
        start = new JButton("Start");
        
        buttons = new JButton[10];
        for (int i=0; i<10; i++){
            buttons[i] = new JButton(" ");
        }
        
        xoTurn = true;
        spacesLeft = 9;
        
    }
    
    public void launchFrame() {
        event = new ButtonListener(this);
        
        frame.setLayout(new BorderLayout());
        frame.add(Grid, BorderLayout.CENTER);
        frame.add(Turn, BorderLayout.NORTH);
        
        Grid.setLayout(new GridLayout(3, 3));
        for (int i=1; i<10; i++){
            Grid.add(buttons[i]);
            buttons[i].addActionListener(event);
            buttons[i].setEnabled(false);
        }
        
        Turn.setLayout(new FlowLayout());
        Turn.add(start);
        Turn.add(buttons[0]);
        buttons[0].setText("Turn: X");
        buttons[0].setEnabled(false);
        
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        start.addActionListener(event);
    }
    
    public JButton getButton(int i){
        return buttons[i];
    }
    
    public JButton[] getButton1(){
        return buttons;
    }
    
    public boolean getTurnX(){
        return xoTurn;
    }
    
    public void setTurnX(boolean xo){
        xoTurn = xo;
    }
    
    public boolean getFinished(){
        return gameOver;
    }
    
    public void setFinished(boolean go){
        gameOver = go;
    }
    
    public int getSpacesLeft() {
        return spacesLeft;
    }
    
    public void setSpacesLeft(int spa){
        spacesLeft = spa;
    }
    
    public void SubtractSpacesLeft(){
        spacesLeft--;
    }
       
	public static void main(String[] args) {
		TicTacToeVC TTT = new TicTacToeVC();
        
		TTT.launchFrame();
	}
}
