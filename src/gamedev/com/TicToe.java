package gamedev.com;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicToe implements ActionListener{
    Random random = new Random();
    JFrame jFrame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text_field = new JLabel();
    JButton[] button = new JButton[9];
    boolean player1_turn;

    TicToe(){
        //главное окно
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800,800);
        jFrame.getContentPane().setBackground(new Color(50,50,50));
        jFrame.setLayout(new BorderLayout());
        jFrame.setVisible(true);

        //text
        text_field.setBackground(new Color(25,25,25));
        text_field.setForeground(new Color(25,255,0));
        text_field.setFont(new Font("Ink Free",Font.BOLD,75));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Krestiki-Noliki");
        text_field.setOpaque(true);
//BorderLayout - макет по умолчанию для обьектов окна,JFrame,JWindow,JDialog
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));
        for (int i=0;i<9;i++){
            button[i] = new JButton();
            button_panel.add(button[i]);
            button[i].setFont(new Font("MV Boli",Font.BOLD,120));
            button[i].setFocusable(false);
            button[i].addActionListener(this);
        //setFocusable - позволяет компоненту
        }

        title_panel.add(text_field);
        jFrame.add(title_panel,BorderLayout.NORTH);
        jFrame.add(button_panel);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0;i<9;i++){
            if (e.getSource()==button[i]){
                if (player1_turn){
                    if (button[i].getText()==""){
                        button[i].setForeground(new Color(255,0,0));
                        button[i].setText("X");
                        player1_turn=false;
                        text_field.setText("O turn");
                    check();
                    }
                }
            else{
                    if (button[i].getText() == "") {
                    button[i].setForeground(new Color(0,0,255));
                    button[i].setText("O");
                    player1_turn=true;
                    text_field.setText("X turn");
                    check();
                    }
                    }
            }
            }

            }
    public void firstTurn(){
        if (random.nextInt(2)==0){
            player1_turn=true;
            text_field.setText("X turn");
        }
        else{
            player1_turn=false;
            text_field.setText("O turn");
        }
    }
    public void check(){
    //check x win conditions
        if (    (button[0].getText()=="X") &&
                (button[1].getText()=="X") &&
                (button[2].getText()=="X")
        ){
            xWins(0,1,2);
        }
        if (    (button[3].getText()=="X") &&
                (button[4].getText()=="X") &&
                (button[5].getText()=="X")
        ){
            xWins(3,4,5);
        }
        if (    (button[6].getText()=="X") &&
                (button[7].getText()=="X") &&
                (button[8].getText()=="X")
        ){
            xWins(6,7,8);
        } if (    (button[0].getText()=="X") &&
                (button[3].getText()=="X") &&
                (button[6].getText()=="X")
        ){
            xWins(0,3,6);
        }
        if (    (button[1].getText()=="X") &&
                (button[4].getText()=="X") &&
                (button[7].getText()=="X")
        ){
            xWins(1,4,7);
        }
        if (    (button[2].getText()=="X") &&
                (button[5].getText()=="X") &&
                (button[8].getText()=="X")
        ){
            xWins(2,5,8);
        }
        if (
                    (button[0].getText()=="X") &&
                        (button[4].getText()=="X")&&
                        (button[8].getText()=="X")
        ){
            xWins(0,4,8);
        }
        if (
                       (button[2].getText()=="X") &&
                        (button[4].getText()=="X")&&
                        (button[6].getText()=="X")
        ){
            xWins(2,4,6);
        }
        //check O conditions
        if (    (button[0].getText()=="O") &&
                (button[1].getText()=="O") &&
                (button[2].getText()=="O")
        ){
            oWins(0,1,2);
        }
        if (    (button[3].getText()=="O") &&
                (button[4].getText()=="O") &&
                (button[5].getText()=="O")
        ){
            oWins(3,4,5);
        }
        if (    (button[6].getText()=="O") &&
                (button[7].getText()=="O") &&
                (button[8].getText()=="O")
        ){
            oWins(6,7,8);
        } if (    (button[0].getText()=="O") &&
                (button[3].getText()=="O") &&
                (button[6].getText()=="O")
        ){
            oWins(0,3,6);
        }
        if (    (button[1].getText()=="O") &&
                (button[4].getText()=="O") &&
                (button[7].getText()=="O")
        ){
            oWins(1,4,7);
        }
        if (    (button[2].getText()=="O") &&
                (button[5].getText()=="O") &&
                (button[8].getText()=="O")
        ){
            oWins(2,5,8);
        }
        if (
                (button[0].getText()=="O") &&
                        (button[4].getText()=="O")&&
                        (button[8].getText()=="O")
        ){
            oWins(0,4,8);
        }
        if (
                (button[2].getText()=="O") &&
                        (button[4].getText()=="O")&&
                        (button[6].getText()=="O")
        ){
            oWins(2,4,6);
        }
    }
    public void xWins(int a,int b, int c){
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);
        for (int i=0;i<9;i++){
            button[i].setEnabled(false);
        }
        text_field.setText("X wins");
    }
    public void oWins(int a, int b , int c){
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);
        for (int i=0;i<9;i++){
            button[i].setEnabled(false);
        }
        text_field.setText("O wins");
    }
}
