package oop1.menu;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

import oop1.*;
import oop1.Login.*;

public class Menu implements ActionListener{

    ImageIcon icon = new ImageIcon("assets/main.png");
    JPanel panel;
    JLabel label;
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
   public static JPanel topPanel;

   public static JFrame menu;
   public static Contact user = new Contact();
   public ImageIcon userIcon =  new ImageIcon(getClass().getResource("/assets/person.png"));

    // Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
   
    public Menu() {
        menu = new JFrame();
        menu.setSize(450,550);
        menu.setLocationRelativeTo(null); 
        menu.setTitle("Main Menu");
        menu.setIconImage(this.icon.getImage());
        menu.setBackground(Color.GRAY);
        menu.setLayout(new FlowLayout());
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 

        btn1 = new JButton("Person");
        btn1.setSize(250, 60);
        btn1.setFocusable(false);

        btn1.addActionListener(this);
        // Mobile button
        btn2 = new JButton("Mobile");
        // btn2.setBounds(0, 0, 200, 40);
        btn2.setSize(250, 60);
        btn2.setFocusable(false);

        // Contact button
        btn3 = new JButton("Contact");
        // btn2.setBounds(0, 0, 200, 40);
        btn3.setSize(250, 60);
        btn3.setFocusable(false);

        // Exit button
        btn4 = new JButton("Exit");
        // btn2.setBounds(0, 0, 200, 40);
        btn4.setSize(250, 60);
        btn4.setFocusable(false);
        btn4.addActionListener(this);

        topPanel = new JPanel();
        topPanel.setBorder(new EmptyBorder(100, 50, 100, 50));
        topPanel.setLayout(new GridLayout(4,1,5,5));
        topPanel.setPreferredSize(new Dimension(300, 450));
        topPanel.setBackground(new Color(196, 203, 204));

        // topPanel.sets
        topPanel.add(btn1);
        topPanel.add(btn2);
        topPanel.add(btn3);
        topPanel.add(btn4);
        btn3.addActionListener(this);
        menu.add(topPanel);

        menu.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            topPanel.setVisible(false);
            menu.add(Contact.person());
            menu.setTitle("Person Info.");
            menu.setIconImage(this.userIcon.getImage());
        } else if (e.getSource() == btn4) {
            System.exit(0);
        }
    }

  
    /**
     * @return
     */
    
    // JButton goMenu;
    // public void menu(JButton l){
    // topPanel.setVisible(true);
    // // personPanel.setVisible(false);
    // goBack.setTitle("Main Menu");
    // // goBack.setIconImage(icon.getImage());
    // }

}
