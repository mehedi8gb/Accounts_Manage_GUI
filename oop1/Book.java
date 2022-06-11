package oop1;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Book {
    String bookName;
    String bookAuthor;
    String bookIdp;
    String bookType;
    int bookCopy;
    public ImageIcon bookicon = new ImageIcon("assets/book.png");

    public Book() {
        System.out.println("Empty Constructor!");
    }

    public Book(String x) {

        System.out.println("Parameterized constructor " + x);
    }

    public void setBookInfo() {
        this.bookName = JOptionPane.showInputDialog("Enter Book Name: ");
        this.bookAuthor = JOptionPane.showInputDialog("Enter Book's Author Name: ");
        this.bookIdp = JOptionPane.showInputDialog("Enter Book's Idp : ");
        this.bookType = JOptionPane.showInputDialog("Enter Book's Type: ");
        int e = Integer.parseInt(JOptionPane.showInputDialog("Enter book copy: "));
        AddBookCopy(e);
    }

    void AddBookCopy(int x) {
        this.bookCopy = x;
    }

    int bookCounter() {
        return this.bookCopy;
    }

    public void showBookInfo() {
        System.out.println("The book name : " + this.bookName +
                "\nbook's Author name : " + this.bookAuthor +
                "\nBook Idp : " + this.bookIdp +
                "\nBook Type :" + this.bookType);
    }

    public void showTotalBookInfo() {

        if (this.bookType != null) {
            JOptionPane.showMessageDialog(null,
                    "The book name : " + this.bookName +
                            "\nbook's Author name : " + this.bookAuthor +
                            "\nBook Idp : " + this.bookIdp +
                            "\nBook Type :" + this.bookType +
                            "\nBook Counts : " + bookCounter(),
                    "----Book information----", JOptionPane.INFORMATION_MESSAGE, bookicon);
        } else {
            JOptionPane.showMessageDialog(null,
                    "You have not added any data yet!",
                    "----oops----", JOptionPane.ERROR_MESSAGE);
        }
    }
}
