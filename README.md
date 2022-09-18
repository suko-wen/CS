import java.awt.Color;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class face {

    public static void main(String[] args) {

        JFrame show = new JFrame("Welcome to the field!");
        show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show.setSize(700, 700);
        GridLayout grid = new GridLayout(3, 3);
        show.getContentPane().setBackground(Color.RED);
        // show.pack();
      
        JTextField text = new JTextField(50);
        JButton b1 = new JButton("Button 1");
        //b1.setBackground(Color.RED);
        int flag = 0;


        int x = 0;
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean flag1 = false;
                // Font.BOLD
                b1.setFont(new Font("Fantasy", Font.ITALIC, 70));
            

                if(flag == 0){

                    text.setText("O");
                    // flag +=1;
                    

                }else{
                    text.setText("X");
                    


                }

    



                b1.setText(text.getText());

                ;

            }


        });

        System.out.println(b1.getText());
        JButton b2 = new JButton("Button 2");


        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // Font.BOLD
                b2.setFont(new Font("Fantasy", Font.ITALIC, 70));

                text.setText("X");

                b2.setText(text.getText());
                ;

            }

        });

        JButton b3 = new JButton("Button 3");

        b3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // Font.BOLD
                b3.setFont(new Font("Fantasy", Font.ITALIC, 70));

                text.setText("O");

                b3.setText(text.getText());
                ;

            }

        });

        JButton b4 = new JButton("Button 4");

        b4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // Font.BOLD
                b4.setFont(new Font("Fantasy", Font.ITALIC, 70));

                text.setText("X");

                b4.setText(text.getText());
                ;

            }

        });

        JButton b5 = new JButton("Button 5");

        b5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // Font.BOLD
                b5.setFont(new Font("Fantasy", Font.ITALIC, 70));

                text.setText("O");

                b5.setText(text.getText());
                ;

            }

        });

        JButton b6 = new JButton("Button 6");

        b6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // Font.BOLD
                b6.setFont(new Font("Fantasy", Font.ITALIC, 70));

                text.setText("X");

                b6.setText(text.getText());
                ;

            }

        });

        JButton b7 = new JButton("Button 7");

        b7.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // Font.BOLD
                b7.setFont(new Font("Fantasy", Font.ITALIC, 70));

                text.setText("O");

                b7.setText(text.getText());
                ;

            }

        });

        JButton b8 = new JButton("Button 8");

        b8.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // Font.BOLD
                b8.setFont(new Font("Fantasy", Font.ITALIC, 70));

                text.setText("X");

                b8.setText(text.getText());
                ;

            }

        });

        JButton b9 = new JButton("Button 9");

        b9.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // Font.BOLD
                b9.setFont(new Font("Fantasy", Font.ITALIC, 70));

                text.setText("O");

                b9.setText(text.getText());
                ;

            }

        });

        Container view = show.getContentPane();
        ;
        view.setLayout(grid);
        view.add(b1);

        view.add(b2);
        view.add(b3);
        view.add(b4);
        view.add(b5);
        view.add(b6);
        view.add(b7);
        view.add(b8);
        view.add(b9);
        show.setVisible(true);

    }

}
                      
