import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

class Transactions extends JFrame implements ActionListener{
JButton deposit,fastcash,withdrawal,mstate,pinchange,balance,exit;
String pin;
Transactions(String pin){
this.pin=pin;


ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
ImageIcon i3 = new ImageIcon(i2);
JLabel l1 = new JLabel(i3);
l1.setBounds(0,0,900,900);
add(l1);

JLabel text = new JLabel("Please select your transaction");
text.setBounds(300,200,700,35);
l1.add(text);
text.setForeground(Color.WHITE);
text.setFont(new Font("System",Font.BOLD,16));

deposit = new JButton("DEPOSIT");
deposit.setBackground(Color.WHITE);
deposit.setForeground(Color.BLACK);
deposit.setFont(new Font("Raleway", Font.BOLD, 14));
deposit.setBounds(250,315,170,30);
deposit.addActionListener(this);
l1.add(deposit);

withdrawal = new JButton("CASH WITHDRAWAL");
withdrawal.setBackground(Color.WHITE);
withdrawal.setForeground(Color.BLACK);
withdrawal.setFont(new Font("Raleway", Font.BOLD, 14));
withdrawal.setBounds(450,315,170,30);
withdrawal.addActionListener(this);
l1.add(withdrawal);

fastcash = new JButton("FAST CASH");
fastcash.setBackground(Color.WHITE);
fastcash.setForeground(Color.BLACK);
fastcash.setFont(new Font("Raleway", Font.BOLD, 14));
fastcash.setBounds(250,350,170,30);
fastcash.addActionListener(this);
l1.add(fastcash);

mstate = new JButton("MINISTATEMENT");
mstate.setBackground(Color.WHITE);
mstate.setForeground(Color.BLACK);
mstate.setFont(new Font("Raleway", Font.BOLD, 14));
mstate.setBounds(450,350,170,30);
mstate.addActionListener(this);
l1.add(mstate);

pinchange = new JButton("PIN CHANGE");
pinchange.setBackground(Color.WHITE);
pinchange.setForeground(Color.BLACK);
pinchange.setFont(new Font("Raleway", Font.BOLD, 14));
pinchange.setBounds(250,385,170,30);
pinchange.addActionListener(this);
l1.add(pinchange);

balance = new JButton("BALANCE ENQUIRY");
balance.setBackground(Color.WHITE);
balance.setForeground(Color.BLACK);
balance.setFont(new Font("Raleway", Font.BOLD, 14));
balance.setBounds(450,385,170,30);
balance.addActionListener(this);
l1.add(balance);

exit = new JButton("EXIT");
exit.setBackground(Color.WHITE);
exit.setForeground(Color.BLACK);
exit.setFont(new Font("Raleway", Font.BOLD, 14));
exit.setBounds(450,420,170,30);
exit.addActionListener(this);
l1.add(exit);











setLayout(null);

setSize(900,900);
setLocation(300,0);
setUndecorated(true);
setVisible(true);

}
public void actionPerformed(ActionEvent ae){
if(ae.getSource() == exit){
System.exit(0);
}
else if(ae.getSource() == deposit){
setVisible(false);
new Deposit(pin).setVisible(true);
}
else if(ae.getSource() == fastcash){
setVisible(false);
new FastCash(pin).setVisible(true);

}
else if(ae.getSource() == mstate){
setVisible(false);
new mstate(pin).setVisible(true);

}
else if(ae.getSource() == balance){
setVisible(false);
new balance(pin).setVisible(true);

}
else if(ae.getSource() == withdrawal){
setVisible(false);
new withdrawal(pin).setVisible(true);

}
else if(ae.getSource() == pinchange){
setVisible(false);
new pinchange(pin).setVisible(true);

}





}
public static void main(String args[]){
new Transactions("");

}
}