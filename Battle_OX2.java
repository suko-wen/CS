
import javax.swing.JButton;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
  
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Battle_OX2 implements ActionListener{
    
    JFrame board = new JFrame();
    JPanel mode = new JPanel();
    JPanel button_mode = new JPanel();
    JLabel text = new JLabel();
    JTextField field_text = new JTextField(50);
    JButton[] buttons = new JButton[9];
    boolean player_mode;
    int count = 0;
    boolean is_human;
    boolean has_winner;

    public Battle_OX2(){

        //board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setSize(1000, 1000);
        board.getContentPane().setBackground(Color.BLUE);
        board.setLayout(new BorderLayout());
        board.setVisible(true);

        text.setBackground(Color.BLUE);
        text.setFont(new Font("Fantasy", Font.ITALIC, 70));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setOpaque(true);

        mode.setLayout(new BorderLayout());
        mode.setBounds(0,0,500,100);

        button_mode.setLayout(new GridLayout(3,3));

        for(int i = 0; i < 9; i++){

            buttons[i] = new JButton("");

        
            buttons[i].setFont(new Font("MV Boli",10,50));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            button_mode.add(buttons[i]);
              

        }
        mode.add(text);
        board.add(mode, BorderLayout.NORTH);
        board.add(button_mode);
        
        is_human = false; //change this to swap 

        Player_mode();

        if(is_human == false){
            computer_turn();
        }

        //
        has_winner = false;
        music();
        

    }

    public void computer_turn() {       
        //this is the computer automated side
        // this is where all empty buttons indexes are stored
        ArrayList<Integer> not_played = new ArrayList<>();

        for (int j = 0; j < 9; j++) {
            if(buttons[j].getText() == ""){
                    not_played.add(j);
            }  
        }

        Random rd = new Random(); // creating Random object
        int val = rd.nextInt(not_played.size());

        int guessed = not_played.get(val);

         if(has_winner == false){

            if(player_mode == true){  // "O"
            
                    field_text.setText("Computer is O");
        
                    buttons[guessed].setForeground(Color.BLUE);
                    field_text.setText("O");
                    buttons[guessed].setText(field_text.getText());
                    player_mode = false;
                    text.setText("X Defend");
                    verify();
                

            }else{ // "X"

                    buttons[guessed].setForeground(Color.BLUE);
                    field_text.setText("X");
                    buttons[guessed].setText(field_text.getText());
                    player_mode = true;
                    text.setText("O Defend");
                    verify();
            }
        

            is_human = true;
        }


    }

    public void actionPerformed(ActionEvent e){
         //This is the human playing side
         if(is_human == true){
            for(int i = 0 ; i < 9;i++){ //Checks every block in grid
                count++;
    
                if(e.getSource() == buttons[i]){ //gets the source of that button
                    if(player_mode == true){ // else if true then O just played
                        
                        if(buttons[i].getText() == ""){

                           buttons[i].setForeground(Color.BLUE);
                           field_text.setText("O");
                           buttons[i].setText(field_text.getText());
                           player_mode = false;
                           text.setText("X Defend");
                           verify();
                        }
    
                    }else{
                        if(buttons[i].getText() == ""){
                            buttons[i].setForeground(Color.BLUE);
                            field_text.setText("X");
                            buttons[i].setText(field_text.getText());
                            player_mode = true;
                            text.setText("O Defend");
                            verify();
    
                         }
    
    
    
                    }
    
    
    
                }

    
            }
            
            is_human = false;
            // calling computer turn after the human has played 
            computer_turn();
        }
  
    }

    public void Player_mode(){



        int val = (int)(Math.random()*(2));
       
        if(val == 1){

            is_human = true;
            text.setText("X Defend!");



        }else{

            is_human = false;
            text.setText("O Defend!");

        }


    }

    private void verify(){
        //verify method that will pass on the winning indexes into the victor method.

        boolean have_winner = false;// initializing the winning variable that will stop computer from trying to play if a winnig combination exist.

       if(buttons[0].getText().equals("X") &&  buttons[1].getText().equals("X") && buttons[2].getText().equals("X")){

            victor_X(0, 1, 2);
            have_winner = true;
        }

        else if(buttons[3].getText().equals("X") &&  buttons[4].getText().equals("X") && buttons[5].getText().equals("X")){

            victor_X(3, 4, 5);
            have_winner = true;
        }

        else if(buttons[6].getText().equals("X") &&  buttons[7].getText().equals("X") && buttons[8].getText().equals( "X")){

            victor_X(6, 7, 8);
            have_winner = true;
        }

        else if(buttons[0].getText().equals("X") &&  buttons[3].getText().equals("X") && buttons[6].getText().equals("X")){

            victor_X(0, 3, 6);
            have_winner = true;
        }

        else if(buttons[1].getText().equals("X") &&  buttons[4].getText().equals("X") && buttons[7].getText().equals("X")){

            victor_X(1, 4, 7);
            have_winner = true;
        }

        else if(buttons[2].getText().equals("X") &&  buttons[5].getText().equals("X") && buttons[8].getText().equals("X")){

            victor_X(2, 5, 8);
            have_winner = true;
        }


        else if(buttons[2].getText().equals("X") &&  buttons[4].getText().equals("X") && buttons[6].getText().equals("X")){

            victor_X(2, 4, 6);
            have_winner = true;
        }


        else if(buttons[0].getText().equals("X") &&  buttons[4].getText().equals("X") && buttons[8].getText().equals("X")){

            victor_X(0, 4, 8);
            have_winner = true;  

        }
        
        else if(buttons[0].getText().equals("O") &&  buttons[1].getText().equals("O") && buttons[2].getText().equals("O")){

            victor_O(0, 1, 2);
            have_winner = true; 

        }

        else if(buttons[3].getText().equals("O") &&  buttons[4].getText().equals("O") && buttons[5].getText().equals("O")){

            victor_O(3, 4, 5);
            have_winner = true;    

        }

        else if(buttons[6].getText().equals("O") &&  buttons[7].getText().equals("O") && buttons[8].getText().equals("O")){

            victor_O(6, 7, 8);
            have_winner = true;   
            
        }

        else if(buttons[0].getText().equals("O") &&  buttons[3].getText().equals("O") && buttons[6].getText().equals( "O")){

            victor_O(0, 3, 6);
            have_winner = true; 
        }

        else if(buttons[1].getText().equals("O") &&  buttons[4].getText().equals("O") && buttons[7].getText().equals("O")){

            victor_O(1, 4, 7);
            have_winner = true; 
        }

        else if(buttons[2].getText().equals("O") &&  buttons[5].getText().equals("O") && buttons[8].getText().equals("O")){

            victor_O(2, 5, 8);
            have_winner = true; 
        }


        else if(buttons[2].getText().equals("O") &&  buttons[4].getText().equals("O") && buttons[6].getText().equals("O")){

            victor_O(2, 4, 6);
            have_winner = true; 
        }


        else if(buttons[0].getText().equals("O") &&  buttons[4].getText().equals("O") && buttons[8].getText().equals("O")){

            victor_O(0, 4, 8);
            have_winner = true; 
        }else{
                if(have_winner == false){
                    victor_Draw();
                }
            }



    }

    public void victor_X(int x, int y, int z){
        
       //winning combination display and disabling of buttons to stop further playing.
      
       buttons[x].setBackground(Color.ORANGE);
       buttons[y].setBackground(Color.ORANGE);
       buttons[z].setBackground(Color.ORANGE);
       
       for(int i = 0; i < 9; i++){

        buttons[i].setEnabled(false);

       }
       
       text.setText("X has won!");
    
       has_winner = true;   // stting winner to true to stop the computer from attempting to play.

             
    


    }

    
    public void victor_O(int x, int y, int z){

        buttons[x].setBackground(Color.RED);
        buttons[y].setBackground(Color.RED);
        buttons[z].setBackground(Color.RED);
        
        for(int i = 0; i < 9; i++){
 
         buttons[i].setEnabled(false);
 
        }
        
        text.setText("O has won!");

        
        has_winner = true;
 

     }
  
     public void  victor_Draw(){
        // draw method is for when all the buttons are filled and no winning combination has occured
        int is_empty = 0;
        for (int i = 0; i < 9; i++) {   //checking if all buttons are filled

            if(buttons[i].getText().equals("")){
                    is_empty++;
            }
            
        }

        if(is_empty == 0){ // if the buttonds are all filled with no empty then it is a draw.
            text.setText("It is a DRAW!,No Winner!");
        }


     }
     
     public void music(){
        //music method responsible to playing a wav music file, it is called in the constructor.
        try{

            //initializig a scanner to scann the audio file.
            Scanner scanner = new Scanner(System.in);
            File file = new File("videoplayback.wav");
      
      
      
          
             try{
              //applyoing classes that will stream the sound or intialize the producing of sound.
              AudioInputStream audios = AudioSystem.getAudioInputStream(file);
              Clip clip = AudioSystem.getClip();
              clip.open(audios);
      
              clip.start();
             }catch(Exception e){
                  
                  System.out.println(e);
      
      
             }
            
            }catch(Exception e){
      
              System.out.println(e);
      
      
      
            }

     }

}
