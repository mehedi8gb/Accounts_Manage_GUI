package oop1.Login;

import javax.swing.JFrame;

import oop1.menu.Menu;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Login
 */
public class Login {
    boolean flag = false;
    String userName;
    String pass;

    public Login() {

        JFrame f = new JFrame("Password Field Example");
        final JLabel label = new JLabel();
        label.setBounds(20, 150, 200, 50);

        final JPasswordField value = new JPasswordField();
        value.setBounds(100, 75, 100, 30);
        JLabel l1 = new JLabel("Username:");

        l1.setBounds(20, 20, 80, 30);
        JLabel l2 = new JLabel("Password:");

        l2.setBounds(20, 75, 80, 30);
        JButton b = new JButton("Login");

        b.setBounds(100, 120, 80, 30);
        final JTextField text = new JTextField();

        text.setBounds(100, 20, 100, 30);
        f.add(value);
        f.add(l1);
        f.add(label);
        f.add(l2);
        f.add(b);
        f.add(text);
        f.setSize(300, 300);
        f.setBackground(Color.LIGHT_GRAY);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                File loginf = new File("H:\\java\\Account_Manage\\data\\users.txt");
                try {
                    Scanner read = new Scanner(loginf);
                    read.useDelimiter(",");
                    while (read.hasNext()) {
                        userName = read.next();
                        pass = read.next();
                        if (userName.equals(text.getText()) || pass.equals(new String(value.getPassword()))) {
                            flag = true;
                            break;
                        }

                        // System.out.println(userName + " " + pass);
                    }
                    if (flag) {
                        f.dispose();
                       Menu m = new Menu();
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "Credentials mismatched!",
                                JOptionPane.ERROR_MESSAGE);
                    }

                    read.close();
                } catch (FileNotFoundException qwerty) {
                    JOptionPane.showMessageDialog(null, "Can't find a text file");
                }
            }
        });

    }

    public String getName() {
        return this.userName;
    }

    public boolean checkAuth() { 
        return flag;
    }

}