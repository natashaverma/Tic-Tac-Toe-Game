package tictactoe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Color.*;



/**
 *
 * @author hp
 */
public class TicTacToeFrame extends JFrame
{
    private char whoseTurn = 'X';
    private boolean  gameOver = false;
    private cell[][] cells = new cell[3][3];
    
    JLabel jlblstatus = new JLabel("X's turn to play");
    
    public TicTacToeFrame (){
        
        JPanel  panel = new JPanel(new GridLayout(3, 3, 0, 0)); // row,col,hgap,vgap
        
        for(int i =0 ;i < 3; i++)
             for(int j =0 ;j < 3; j++)
                 panel.add(cells[i][j] = new cell());
                 panel.setBorder(new LineBorder(Color.red,1));
                 
                 jlblstatus.setBorder(new LineBorder(Color.yellow, 1));
             
       add(panel , BorderLayout.CENTER);
       add(jlblstatus, BorderLayout.SOUTH);
       
    }
    
    public boolean isFull(){
        for(int i =0 ;i < 3; i++)
             for(int j =0 ;j < 3; j++)
                 if(cells[i][j].getToken() == ' ')
                     return false;
                 
        return true;
    }
    
    public boolean isWon(char token){
        
        for(int i =0; i < 3; i++)
            
                  if((cells[i][0].getToken() == token)
             &&   (cells[i][1].getToken() == token)
             &&    (cells[i][2].getToken() == token))
             {
                 return true;
             }
             
           for(int j =0 ;j <3; j++)  
            if((cells[0][j].getToken() == token)
                && (cells[1][j].getToken() == token)
                    && (cells[2][j].getToken() == token)){
                        return true;
                    }
        //check diagonal
        
        
        if((cells[0][0].getToken() == token)
            && (cells[1][1].getToken() == token)
       &&  (cells[2][2].getToken() == token)){
           return true;
       }
       
       if((cells[0][2].getToken() == token)
           &&  (cells[1][1].getToken() == token)
               &&  (cells[2][0].getToken() == token)){
                   return true;
               }
         return false;      
    }

public class cell extends JPanel
{
    private char token = ' ';
    
    public cell(){
        
        setBorder(new LineBorder(Color.black, 1));
        addMouseListener(new MyMouseListener());
    }
    
    public char getToken(){
        return token;
    }
    
    public void setToken(char c){
        token = c;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g){
        
        super.paintComponent(g);
        if(token == 'X'){
            g.drawLine(10, 10, getWidth()-10, getHeight()-10);
        g.drawLine(getWidth()-10 , 10 ,10 , getHeight()-10);
                
    }
        else if(token == 'O'){
            
           g.drawOval(10, 10, getWidth() -20, getHeight() -20);
           
        }
    }
    
           private class MyMouseListener extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            
            if(gameOver)
                return;
            
            
            if(token == ' ' && whoseTurn != ' ')
                setToken(whoseTurn);
            
            if(isWon(whoseTurn)){
                jlblstatus.setText(whoseTurn + " Won! Game Over!");
                whoseTurn = ' ';
                gameOver = true;
            }
            else if(isFull()){
                jlblstatus.setText("Tie Game!");
                whoseTurn = ' ';
                gameOver = true;
            }
            else{
                whoseTurn = whoseTurn == 'X'?'O': 'X';
                jlblstatus.setText(whoseTurn+ "'s Turn.");
            }
        }
        
    }
    
}

}
