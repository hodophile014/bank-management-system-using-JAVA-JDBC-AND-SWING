import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Login extends JFrame implements ActionListener{
JButton login, sign ,clear;
JTextField cardfield;
JPasswordField pinText;


Login(){
ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/user.png"));
Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
ImageIcon i3 = new ImageIcon(i2);
JLabel l1 = new JLabel(i3);
l1.setBounds(70,10,100,100);
add(l1);
getContentPane().setBackground(Color.WHITE);


JLabel text = new JLabel("WELCOME TO ATM");
add(text);
text.setFont(new Font("Osward",Font.BOLD, 38));
text.setBounds(200,40,450,40);


JLabel cardno = new JLabel("CARD NO.");
add(cardno);
cardno.setFont(new Font("Raleway",Font.BOLD, 28));
cardno.setBounds(125,150,375,30);



JLabel pin = new JLabel("PIN");
add(pin);
pin.setFont(new Font("Raleway",Font.BOLD, 28));
pin.setBounds(125,220,375,30);


cardfield = new JTextField();
cardfield.setBounds(300,150,230,30);
cardfield.setFont(new Font("Arial",Font.BOLD,28));
add(cardfield);



pinText = new JPasswordField();
pinText.setBounds(300, 220, 230,30);
pinText.setFont(new Font("Arial", Font.BOLD, 14));
add(pinText);

login = new JButton("SIGN IN");
login.setBounds(430,300,100,30);
login.setBackground(Color.BLACK);
login.setForeground(Color.WHITE);
login.addActionListener(this);
add(login);

clear = new JButton("CLEAR");
clear.setBounds(300,300,100,30);
clear.setBackground(Color.BLACK);
clear.setForeground(Color.WHITE);
clear.addActionListener(this);
add(clear);

sign = new JButton("SIGN UP");
sign.setBounds(300,350,230,30);
sign.setBackground(Color.BLACK);
sign.setForeground(Color.WHITE);
sign.addActionListener(this);
add(sign);



setSize(800,480);
setLayout(null);
setVisible(true);
setLocation(350,200);
setTitle("ATM");

}
public void actionPerformed(ActionEvent ae){
 if(ae.getSource() == clear){
cardfield.setText("");
pinText.setText("");
}

else if(ae.getSource() == login){
try{
Conn conn = new Conn();
String cardnumber = cardfield.getText();
String pinNumber = pinText.getText();
String query = "select * from Login where card_number= '"+cardnumber+"' and pinNumber= '"+pinNumber+"'";
ResultSet rs = conn.s.executeQuery(query);
if(rs.next()){
setVisible(false);
new Transactions(pinNumber).setVisible(true);
}
else{
JOptionPane.showMessageDialog(null,"INCORRECT PIN OR CARD NUMBER");
}

}
catch(Exception e){
}

}
else if(ae.getSource() == sign){
signUp s = new signUp();
s.setVisible(true);
setVisible(false);
}



}
public static void main(String args[]){
new Login();


}
}