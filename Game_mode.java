import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
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


public class Game_mode implements ActionListener{
    // initialize attributes which are classes needed for a GUI.
    ImageIcon Pic2 = new ImageIcon("Pi.gif");
    ImageIcon Pic = new ImageIcon("R.png");
    Font myFont = new Font("Courier", Font.BOLD | Font.ITALIC ,50);

    

    JLabel pho = new JLabel(Pic);
    JLabel pho2 = new JLabel(Pic2);


    JFrame frame = new JFrame();
    JLabel text = new JLabel();
    
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    
    JButton touch1 = new JButton("Multiplayer");
    JButton touch2 = new JButton("Single player");

    //Constructor for the game mose.
    public Game_mode(){
        
        text.setFont(new Font("Courier", Font.BOLD | Font.ITALIC ,100));
        text.setBackground(Color.RED.darker());
        text.setForeground(Color.white);
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setBounds(0, 0, 540, 540);
        text.setText("BATTLE OX!");
        text.setOpaque(true);
        //text.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Color.white, Color.white));
        touch1.setBounds(70, 40, 70, 40);
        
        touch1.setFont(myFont);
        
        //touch1.setFont(new Font("Ink Free",10,50));
        touch1.setBackground(Color.RED.darker());
        touch1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        touch1.setHorizontalAlignment(JButton.CENTER);
        touch1.setForeground(Color.white);
        touch1.setFocusable(false);
        touch1.addActionListener(this);

             
        touch2.setBounds(500, 40,500, 40);
        //touch2.setFont(new Font("Ink Free",10,50));
        touch2.setHorizontalAlignment(JButton.LEFT);
        touch2.setBackground(Color.RED.darker());
        touch2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        
        touch2.setFont(myFont);
        touch2.setForeground(Color.white);
        touch2.setFocusable(false);
        touch2.addActionListener(this);
        
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        
        panel.setBounds(500,500,500,500);
        //panel.setSize(200, 200);
        panel.setBackground(Color.BLACK.darker());
        panel2.setBackground(Color.RED.darker());
        
        
        panel.setBounds(400, 400, 240, 240);
        panel2.add(text);

        //panel.add(pho);
        
        panel.add(pho);
        panel.add(touch1); 
        panel.add(touch2);
        frame.add(panel);
        frame.add(panel2, BorderLayout.NORTH);
    
        frame.setForeground(Color.YELLOW);
        frame.setBackground(Color.YELLOW);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);
        frame.setVisible(true);

        

        
        for(int i = 0; i < 20; i++){
           
            music(); //the music method called, used the for loop to create the choppy robotic sound
 
        }



    }

     // a method that comes with the implement action that control what the button does
    public void actionPerformed(ActionEvent e){
            // clicking the buttons will call a new class for the modes of game and dispose the current GUI
            if(e.getSource() == touch1){   
             frame.dispose();   
             Battle_OX tic_tac = new Battle_OX();//call the game class that allow human vs human
 
            }else if(e.getSource() == touch2){
                frame.dispose();   
                //BOX tic_tac = new BOX(); //call ther class that allow human vs computer
                Battle_OX2 tic_tac = new Battle_OX2();
 

            }

    }



    //the music method that allows a background sound as this class is called. 
    public void music(){

      

        try{

       
            Scanner scanner = new Scanner(System.in);
            File file = new File("WhatsApp Audio 2022-10-06 at 22.17.53.wav");
      
      
      
          
             try{
      
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
