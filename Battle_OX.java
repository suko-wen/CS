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


public class Battle_OX implements ActionListener{
    //Jrame + Jpanel +Jlabel + JButton will make up the GUI 
    JFrame board = new JFrame();
    JPanel mode = new JPanel();
    JPanel button_mode = new JPanel();
    JLabel text = new JLabel();
    JTextField field_text = new JTextField(50);
    JButton[] buttons = new JButton[9];
    boolean player_mode;
    int win = 1;
    int count = 0;

    public Battle_OX(){
        //setting of the frame size and other features
        board.setSize(1000, 1000);
        board.getContentPane().setBackground(Color.BLUE);
        board.setLayout(new BorderLayout());
        board.setVisible(true);

        text.setBackground(Color.BLUE);
        text.setFont(new Font("Fantasy", Font.ITALIC, 70));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setOpaque(true);
        //panel for the heading  
        mode.setLayout(new BorderLayout());
        mode.setBounds(0,0,500,100);
        // a panel where the buttons are added and formatted into a 3X3 GRID
        button_mode.setLayout(new GridLayout(3,3));
    
        //creating buttons and adding action listener.
        for(int i = 0; i < 9; i++){

            buttons[i] = new JButton("");

        
            buttons[i].setFont(new Font("MV Boli",10,50));
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            button_mode.add(buttons[i]);
              

        }

        //adding text to the heading & adding to the frame all panels
        mode.add(text);
        board.add(mode, BorderLayout.NORTH);
        board.add(button_mode);
        

        Player_mode();
    
            music();
        

          

    }

    public void actionPerformed(ActionEvent e){


        

        for(int i = 0 ; i < 9;i++){ //Checks every block in grid
            count++;

            if(e.getSource() == buttons[i]){ //gets the source of that button
                if(player_mode == true){ // if true then O just played
                    
                    if(buttons[i].getText() == ""){
                       buttons[i].setForeground(Color.white);
                       field_text.setText("O");
                       buttons[i].setText(field_text.getText());
                       player_mode = false;
                       text.setText("X Defend");
                       verify();
                     //  victor_Draw();

                    }

                }else{
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(Color.RED);
                        field_text.setText("X");
                        buttons[i].setText(field_text.getText());
                        player_mode = true;
                        text.setText("O Defend");
                        verify();
                       // victor_Draw();
                     }



                }



            }




        }

    }
  
    public void Player_mode(){ // method that will randomize who is playing first


        text.setText("WELCOME TO BATTLE OX!");
        
        try{
            Thread.sleep(5000);
            text.setBackground(Color.RED);
        }catch(Exception e){

        }

        // if random is 1 then "O" start if it is 0 then "X"
        int val = (int)(Math.random()*(2));

        if(val == 1){

            player_mode = true;
            text.setText("O Defend!");



        }else{

            player_mode = false;
            text.setText("X Defend!");

        }


    }


    //This is the method that will determine the winning conditions are according to the matching buttons.
    private void verify(){

        int draw = 0;
        boolean have_winner = false;

        if(buttons[0].getText().equals("X") &&  buttons[1].getText().equals("X") && buttons[2].getText().equals("X")){

            victor_X(0, 1, 2);  // it will call the victor method to pass on the indexes of those matching buttons
            draw += 1;
            have_winner = true;
        }
        else if(buttons[3].getText().equals("X") &&  buttons[4].getText().equals("X") && buttons[5].getText().equals("X")){

            victor_X(3, 4, 5);
            draw += 1;
            have_winner = true;
        }

        else if(buttons[6].getText().equals("X") &&  buttons[7].getText().equals("X") && buttons[8].getText().equals( "X")){

            victor_X(6, 7, 8);
            draw += 1;
            have_winner = true;
        }
        else if(buttons[0].getText().equals("X") &&  buttons[3].getText().equals("X") && buttons[6].getText().equals("X")){

            victor_X(0, 3, 6);
            draw += 1;
            have_winner = true;
        }

        else if(buttons[1].getText().equals("X") &&  buttons[4].getText().equals("X") && buttons[7].getText().equals("X")){

            victor_X(1, 4, 7);
            draw += 1;
            have_winner = true;
        }
        else if(buttons[2].getText().equals("X") &&  buttons[5].getText().equals("X") && buttons[8].getText().equals("X")){

            victor_X(2, 5, 8);
            draw += 1;
            have_winner = true;
        }


        else if(buttons[2].getText().equals("X") &&  buttons[4].getText().equals("X") && buttons[6].getText().equals("X")){

            victor_X(2, 4, 6);
            draw += 1;
            have_winner = true;
        }


        else if(buttons[0].getText().equals("X") &&  buttons[4].getText().equals("X") && buttons[8].getText().equals("X")){

            victor_X(0, 4, 8);
            draw +=1;
            have_winner = true;
        }





        
        else if(buttons[0].getText().equals("O") &&  buttons[1].getText().equals("O") && buttons[2].getText().equals("O")){

            victor_O(0, 1, 2);
            draw += 1;
            have_winner = true;
        }

        else if(buttons[3].getText().equals("O") &&  buttons[4].getText().equals("O") && buttons[5].getText().equals("O")){

            victor_O(3, 4, 5);
            draw += 1;
            have_winner = true;
        }

        else if(buttons[6].getText().equals("O") &&  buttons[7].getText().equals("O") && buttons[8].getText().equals("O")){

            victor_O(6, 7, 8);
            draw += 1;
            have_winner = true;
        }
        else if(buttons[0].getText().equals("O") &&  buttons[3].getText().equals("O") && buttons[6].getText().equals( "O")){

            victor_O(0, 3, 6);
            draw += 1;
            have_winner = true;
        }

        else if(buttons[1].getText().equals("O") &&  buttons[4].getText().equals("O") && buttons[7].getText().equals("O")){

            victor_O(1, 4, 7);
            draw += 1;
            have_winner = true;
        }

        else if(buttons[2].getText().equals("O") &&  buttons[5].getText().equals("O") && buttons[8].getText().equals("O")){

            victor_O(2, 5, 8);
            draw += 1;
            have_winner = true;
        }


        else if(buttons[2].getText().equals("O") &&  buttons[4].getText().equals("O") && buttons[6].getText().equals("O")){

            victor_O(2, 4, 6);
            draw += 1;
            have_winner = true;
        }


        else if(buttons[0].getText().equals("O") &&  buttons[4].getText().equals("O") && buttons[8].getText().equals("O")){

            victor_O(0, 4, 8);
            draw += 1;
            have_winner = true;
        }else{

        // if(draw != 1){

            if(have_winner == false){
                victor_Draw();
            }
        }
















    }
    
    //Victor method for X that will pass the indexes of the winning combi nation.
    public void victor_X(int x, int y, int z){
       // distinguish the winning combination so it can be identified by same colour
       buttons[x].setBackground(Color.ORANGE);
       buttons[y].setBackground(Color.ORANGE);
       buttons[z].setBackground(Color.ORANGE);
       
       for(int i = 0; i < 9; i++){
        //disabling all buttons after a winning combination has occured.
        buttons[i].setEnabled(false);

       }

       win -=1;
       
       text.setText("X has won!");


             
    


    }

    //victore method for O that does same as the one for X
    public void victor_O(int x, int y, int z){


        buttons[x].setBackground(Color.RED);
        buttons[y].setBackground(Color.RED);
        buttons[z].setBackground(Color.RED);
        
        for(int i = 0; i < 9; i++){
 
         buttons[i].setEnabled(false);
 
        }
        win -=1;
        text.setText("O has won!");
 
 
              
     
 
 
     }

     public void  victor_Draw(){

        int is_full = 0;
        for (int i = 0; i < 9; i++) {

            if(buttons[i].getText().equals("")){
                    is_full++;
            }
            
        }

        if(is_full == 0){
            text.setText("It is a DRAW!,No Winner!");
        }


     }
     
     //music method that will play the music.
     public void music(){

      

        try{

            //initializig a scanner to scann the audio file.
            Scanner scanner = new Scanner(System.in);
            File file = new File("mp3juices.vin-He-s-a-Pirate-_128kbps_.wav");
      
      
      
          
             try{
      
              AudioInputStream audios = AudioSystem.getAudioInputStream(file);
              Clip clip = AudioSystem.getClip();
              clip.open(audios);
      
              clip.start();
             }catch(Exception e){
                  
                  System.out.println(e);
      
      
             }
            
        
      
            // String play = scanner.next();
      
      
            }catch(Exception e){
      
              System.out.println(e);
      
      
      
            }






     }





}
