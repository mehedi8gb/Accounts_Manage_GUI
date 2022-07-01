package oop1;
import oop1.menu.Menu;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Contact{
    static String personName;
    public static String personId;
    static String age;
   static String mobileNumber;
   static String address;
   static Character gender;
   static String operator;
   static ImageIcon userIcon =  new ImageIcon("/assets/person.png");
   static ImageIcon icon = new ImageIcon("assets/person.png");
   static JPanel panel;
   static JLabel label;
   static JButton btn1;
   static JButton btn2;
    // JButton btn3;
    // JPanel topPanel;



    public ImageIcon contactIcon = new ImageIcon("assets/person.png");

    

    public Contact() { }


    public static JPanel person() {

        JButton btn5 = new JButton("Add Person");
        // btn5.addActionListener(this);
        JButton btn6 = new JButton("Show Data");
        if (Menu.user.getName() == null) {
            btn6.setEnabled(false);
            btn6.setToolTipText("Add User Information to Enable this Button");
        }
        JButton btn7 = new JButton("Back");
        
        JPanel personPanel = new JPanel();
        personPanel.setBorder(new EmptyBorder(100, 50, 100, 50));
        personPanel.setLayout(new FlowLayout());
        personPanel.setPreferredSize(new Dimension(300, 450));
        personPanel.setBackground(new Color(196, 203, 204));
        personPanel.add(btn5);
        personPanel.add(btn6);
        personPanel.add(btn7);
        personPanel.setVisible(true);

        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.topPanel.setVisible(true);
                personPanel.setVisible(false);
                Menu.menu.setTitle("Main Menu");
                Menu.menu.setIconImage(icon.getImage());
            }
        });
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.topPanel.setVisible(false);
                personPanel.setVisible(false);
                Menu.menu.add(ShowPersonInfo());
                // user.ShowPersonInfo();
                Menu.menu.setTitle(Menu.user.getName() + "'s information");
                // menu.pack();
                Menu.menu.setVisible(true);

            }
        });
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // topPanel.setVisible(false);
                personPanel.setVisible(false);
                Menu.menu.add(Contact.addPerson());
                Menu.menu.setTitle("Add user information");
                // goBack.pack();
                // goBack.setVisible(true);

            }
        });

        return personPanel;
    }



    public static JPanel addPerson() {

        JLabel nameL = new JLabel("enter your Name:");
        JTextField name = new JTextField();
        name.setPreferredSize(new Dimension(100, 30));

        JLabel idL = new JLabel("enter your ID:");
        JTextField id = new JTextField();
        id.setPreferredSize(new Dimension(100, 30));

        JLabel ageL = new JLabel("enter your Age:");
        JTextField age = new JTextField();

        age.setPreferredSize(new Dimension(100, 30));

        JLabel mobileL = new JLabel("enter your Mobile number:");
        JTextField mobile = new JTextField();
        mobile.setPreferredSize(new Dimension(100, 30));

        JLabel addressL = new JLabel("enter your Address:");
        JTextField address = new JTextField();
        address.setPreferredSize(new Dimension(100, 30));

        JPanel formGroup = new JPanel();
        // formGroup.setLayout(new BoxLayout(formGroup, BoxLayout.Y_AXIS));
        formGroup.setLayout(new GridLayout(5,2,5,8));
        formGroup.add(nameL);
        formGroup.setBackground(new Color(196, 203, 204));
        // formGroup.add(Box.createVerticalStrut(4));
        formGroup.add(name);
        // formGroup.add(Box.createVerticalStrut(6));
        formGroup.add(idL);
        // formGroup.add(Box.createVerticalStrut(4));
        formGroup.add(id);
        // formGroup.add(Box.createVerticalStrut(6));
        formGroup.add(ageL);
        // formGroup.add(Box.createVerticalStrut(4));
        formGroup.add(age);
        // formGroup.add(Box.createVerticalStrut(6));
        formGroup.add(mobileL);
        // formGroup.add(Box.createVerticalStrut(4));
        formGroup.add(mobile);
        // formGroup.add(Box.createVerticalStrut(6));
        formGroup.add(addressL);
        // formGroup.add(Box.createVerticalStrut(4));
        formGroup.add(address);

        JButton submit = new JButton("Submit Info");

        JButton back = new JButton("Back to Menu");

        JPanel buttonGroup = new JPanel();
        buttonGroup.setBackground(new Color(196, 203, 204));
        buttonGroup.add(submit);
        buttonGroup.add(back);

        JPanel addPerson = new JPanel();
        addPerson.setBorder(new EmptyBorder(20, 30, 100, 30));

        addPerson.setPreferredSize(new Dimension(400, 500));
        addPerson.setBackground(new Color(196, 203, 204));
        // addPerson.setHorizontalAlignment(JLabel.CENTER);

        JLabel info = new JLabel("Enter User Informations");
        info.setLayout(new BoxLayout(info, BoxLayout.LINE_AXIS));
        info.setFont(new Font("Sans Serif", Font.BOLD, 20));
        addPerson.add(new JLabel(userIcon));
        addPerson.add(info);
        addPerson.add(formGroup, BorderLayout.WEST);
        addPerson.add(Box.createVerticalStrut(6));
        addPerson.add(buttonGroup);
        addPerson.setVisible(true);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               addPerson.setVisible(false);
               Menu.topPanel.setVisible(true);
                
                Menu.menu.setTitle("Main Menu");
                Menu.menu.setIconImage(icon.getImage());
            }
        });
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            if (e.getSource() == submit) {

                    if (name.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Name field can't empty!", "Field missing",
                                JOptionPane.ERROR_MESSAGE);
                    }

                    else if (id.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "ID field can't empty!", "Field missing",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    
                    else if (age.getText().isEmpty()) {

                        JOptionPane.showMessageDialog(null, "Age field can't empty!", "Field missing",
                                JOptionPane.ERROR_MESSAGE);
                    } 
                    else if (!age.getText().matches("^\\d+$")) {
                        JOptionPane.showMessageDialog(null, "Age field contain non-integer value",
                                "Something Went Wrong",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    else if (mobile.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Mobile number field can't empty!", "Field missing",
                                JOptionPane.ERROR_MESSAGE);
                    }

                    else if (address.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Address field can't empty!",
                                "Something Went Wrong",
                                JOptionPane.ERROR_MESSAGE);
                    }
                                       
                     else {
                        Menu.user.setInfo(name.getText(), id.getText(), mobile.getText(), age.getText(),
                                address.getText());
                        JOptionPane.showMessageDialog(null, "Data Added Successfully", "success",
                                JOptionPane.INFORMATION_MESSAGE);
                                Menu.topPanel.setVisible(true);
                        addPerson.setVisible(false);
                        Menu.menu.setTitle("Main Menu");
                        // goBack.setIconImage(icon.getImage());
                    }
                }                
            }
        });
        return addPerson;
    }




    public String getName(){
        return personName;
    }

    public void setInfo(String a, String b, String c, String d, String e) {
        personName = a;
        personId = b;
        mobileNumber = c;
        age = d;
        address = e;

    }

    public static JPanel ShowPersonInfo() {
        DetectMobileOperator();
        JPanel UserInfo = new JPanel();
        JLabel nameL = new JLabel("Name : ");
        JLabel Name = new JLabel(personName);
        // Name.setText("<html><body></br></body></html>");
        JLabel idL = new JLabel("ID : ");
        JLabel Id = new JLabel(personId);

        JLabel AgeL = new JLabel("AGE : ");
        JLabel Age = new JLabel(age);

        JLabel MobileL = new JLabel("Mobile Number : ");
        JLabel Mobile = new JLabel(mobileNumber);

        JLabel OperatorL = new JLabel("Operator");
        JLabel Operator = new JLabel(operator);

        JLabel AddressL = new JLabel("Address : ");
        JLabel Address = new JLabel(mobileNumber);
         btn1 = new JButton("Edit Data");
         btn2 = new JButton("Go to Main Menu");
      

        UserInfo.setBorder(new EmptyBorder(10,30,100,30));
        UserInfo.setLayout(new GridLayout(7,2));
        UserInfo.setBackground(new Color(196, 203, 204));
        UserInfo.setPreferredSize(new Dimension(300,300));
        UserInfo.setFont(new Font("Sans Serif",Font.BOLD,25));
        UserInfo.setForeground(Color.MAGENTA);
        UserInfo.add(nameL);
        UserInfo.add(Name);
        UserInfo.add(idL);
        UserInfo.add(Id);
        UserInfo.add(AgeL);
        UserInfo.add(Age);
        UserInfo.add(MobileL);
        UserInfo.add(Mobile);
        UserInfo.add(OperatorL);
        UserInfo.add(Operator);
        UserInfo.add(AddressL);
        UserInfo.add(Address);
        UserInfo.add(btn1);
        UserInfo.add(btn2);
        UserInfo.setVisible(true);

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               UserInfo.setVisible(false);
              Menu.menu.setTitle("Main Menu"); 
              Menu.topPanel.setVisible(true); 
              
            }
        });
        return UserInfo;
     
        
    }

    static void DetectMobileOperator() {
        if (mobileNumber.charAt(2) == '7') {
            operator = "GP";
        } else if (mobileNumber.charAt(2) == '8') {
            operator = "Robi";
        } else {
            operator = "ETC";
        }
    }
}
