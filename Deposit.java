import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class Deposit extends JFrame implements ActionListener{
JTextField Amount;
JButton cancel,CONTINUE;
String pin;
Deposit(String pin){
this.pin=pin;

ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/wally.png"));
Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
ImageIcon i3 = new ImageIcon(i2);
JLabel l1 = new JLabel(i3);
l1.setBounds(0,0,900,900);
add(l1);

JLabel text = new JLabel("Please enter the amount you want to deposit");
text.setBounds(170,300,700,35);
l1.add(text);
text.setForeground(Color.black);
text.setFont(new Font("System",Font.BOLD,28));

Amount = new JTextField();
Amount.setFont(new Font("Raleway", Font.BOLD,22));
Amount.setBounds(270,350,320,25);
l1.add(Amount);

cancel = new JButton("CANCEL");
cancel.setBackground(Color.BLACK);
cancel.setForeground(Color.YELLOW);
cancel.setFont(new Font("Raleway", Font.BOLD, 14));
cancel.setBounds(355,520,150,30);
cancel.addActionListener(this);
l1.add(cancel);

CONTINUE = new JButton("CONTINUE");
CONTINUE.setBackground(Color.BLACK);
CONTINUE.setForeground(Color.YELLOW);
CONTINUE.setFont(new Font("Raleway", Font.BOLD, 14));
CONTINUE.setBounds(355,485,150,30);
CONTINUE.addActionListener(this);
l1.add(CONTINUE);







setLayout(null);

setSize(900,900);
setLocation(300,0);
//setUndecorated(true);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource() == cancel){
System.exit(0);
}
else if(ae.getSource()==CONTINUE){
if(Amount.getText().equals("")){
JOptionPane.showMessageDialog(null,"please enter the amount to be depsoited");
}
else{
try{
String number = ""+Amount.getText();
Date d = new Date();
Conn c = new Conn();
String query = "insert into bank values('"+pin+"','"+d+"','deposit','"+number+"')";
c.s.executeUpdate(query);
JOptionPane.showMessageDialog(null,"Rs."+number+"Deposit successfully");
setVisible(false);
new Transactions(pin).setVisible(true);

}
catch(Exception e){
System.out.println(e);
}





}

}
}
public static void main(String[] args){
new Deposit("");

}
}