package com.glim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game implements ActionListener{
    Random random = new Random();
    JFrame jframe = new JFrame();
    JPanel title = new JPanel();
    JPanel button = new JPanel();
    JLabel text = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean Player1Turn;
    
    Game() throws InterruptedException {
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(800, 800);
        jframe.getContentPane().setBackground(new Color(200, 162, 200));
        jframe.setLayout(new BorderLayout());
        jframe.setVisible(true);
        jframe.setResizable(false);
        
        text.setBackground(new Color(128,128,128));
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Ink Free", Font.BOLD,75));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("Tic Tac Toe");
        text.setOpaque(true);

        title.setLayout(new BorderLayout());
        title.setBounds(0,0,800,100);

        button.setLayout(new GridLayout(3,3));
        button.setBackground(new Color(200, 162, 200));

        for(int i=0;i<9;i++){
            Thread.sleep(1000);
            buttons[i] = new JButton();
            button.add(buttons[i]);
            buttons[i].setFont(new Font("Roboto",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title.add(text);
        jframe.add(title,BorderLayout.NORTH);
        jframe.add(button);

        firstturn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(Player1Turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        Player1Turn=false;
                        text.setText("0 TURN");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        Player1Turn=true;
                        text.setText("X TURN");
                        check();
                    }
                }
            }
        }

    }
    public void firstturn(){
        if((random.nextInt(2)==0)){
            Player1Turn=true;
            text.setText("X Turn");

        }
        else{
            Player1Turn=false;
            text.setText("0 Turn");
        }

    }
    public void check(){
        //checks if X won
        if(     (buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X") &&
                (buttons[2].getText()=="X")){
            xwon(0,1,2);

        }
        if(     (buttons[3].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[5].getText()=="X")){
            xwon(3,4,5);
        }
        if(     (buttons[6].getText()=="X") &&
                (buttons[7].getText()=="X") &&
                (buttons[8].getText()=="X")){
            xwon(6,7,8);

        }
        if(     (buttons[0].getText()=="X") &&
                (buttons[3].getText()=="X") &&
                (buttons[6].getText()=="X")){
            xwon(0,3,6);

        }
        if(     (buttons[1].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[7].getText()=="X")){
            xwon(1,4,7);

        }
        if(     (buttons[2].getText()=="X") &&
                (buttons[5].getText()=="X") &&
                (buttons[8].getText()=="X")){
            xwon(2,5,8);

        }
        if(     (buttons[0].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[8].getText()=="X")){
            xwon(0,4,8);

        }
        if(     (buttons[2].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[6].getText()=="X")){
            xwon(2,4,6);

        }
        //checks if o won
        if(     (buttons[0].getText()=="O") &&
                (buttons[1].getText()=="O") &&
                (buttons[2].getText()=="O")){
            owon(0,1,2);

        }
        if(     (buttons[3].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[5].getText()=="O")){
            owon(3,4,5);
        }
        if(     (buttons[6].getText()=="O") &&
                (buttons[7].getText()=="O") &&
                (buttons[8].getText()=="O")){
            owon(6,7,8);

        }
        if(     (buttons[0].getText()=="O") &&
                (buttons[3].getText()=="O") &&
                (buttons[6].getText()=="O")){
            owon(0,3,6);

        }
        if(     (buttons[1].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[7].getText()=="O")){
            owon(1,4,7);

        }
        if(     (buttons[2].getText()=="O") &&
                (buttons[5].getText()=="O") &&
                (buttons[8].getText()=="O")){
            owon(2,5,8);

        }
        if(     (buttons[0].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[8].getText()=="O")){
            owon(0,4,8);

        }
        if(     (buttons[2].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[6].getText()=="O")){
            owon(2,4,6);

        }

    }
    public void xwon(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);

        }
        text.setText("X Wins");

    }
    public void owon(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);

        }
        text.setText("O Wins");

    }
}
