package oop1;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Contact {
    String personName;
    String personId;
    int age;
    String mobileNumber;;
    Character gender;
    String operator;
    public ImageIcon contactIcon = new ImageIcon("assets/person.png");

    public Contact() {
        System.out.println("Empty Constructor!");
    }

    public Contact(String x) {

        System.out.println("Parameterized constructor " + x);
    }

    public void setInfo() {
        String a = JOptionPane.showInputDialog("Enter Person's Name: ");
        String b = JOptionPane.showInputDialog("Enter Person's ID : ");
        String c = JOptionPane.showInputDialog("Enter Person's Mobile Number : ");
        int d = Integer.parseInt(JOptionPane.showInputDialog("Enter Person's Age : "));
        String e = JOptionPane.showInputDialog("Enter Gender [ex:M/F] : ");
        Character gender = e.charAt(0);

        this.personName = a;
        this.personId = b;
        this.mobileNumber = c;
        this.age = d;
        this.gender = gender;

    }

    public void ShowPersonInfo() {
        if (personId != null) {
            DetectMobileOperator();
            JOptionPane.showMessageDialog(null,
                    "Person Name: " + this.personName +
                            "\nPerson ID : " + this.personId +
                            "\nPerson Mobile Number : " + this.mobileNumber +
                            "\nPerson Mobile Operator : " + this.operator +
                            "\nPerson Age : " + this.age +
                            "\nPerson Gender : " + this.gender,
                    "----The Person information----", JOptionPane.INFORMATION_MESSAGE, contactIcon);
        } else {
            JOptionPane.showMessageDialog(null,
                    "You have not added any data yet!",
                    "----oops----", JOptionPane.ERROR_MESSAGE);
        }
    }

    void DetectMobileOperator() {
        if (mobileNumber.charAt(2) == '7') {
            this.operator = "GP";
        } else if (mobileNumber.charAt(2) == '8') {
            this.operator = "Robi";
        } else {
            this.operator = "ETC";
        }
    }
}
