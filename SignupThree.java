import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;

public class SignupThree extends JFrame implements ActionListener{
JRadioButton r1,r2, r3,r4;
JCheckBox c1,c2,c3,c4,c5,c6,c7;
JButton cancel,submit;
String formno;
SignupThree(String formno){
this.formno=formno;

JLabel l1 = new JLabel("PAGE 3: ACCOUNT DETAILS");
l1.setFont(new Font("Raleway", Font.BOLD, 22));
l1.setBounds(280,40,400,40);
add(l1);

JLabel type = new JLabel("ACCOUNT TYPE");
type.setFont(new Font("Raleway", Font.BOLD, 22));
type.setBounds(100,140,200,30);
add(type);


r1 = new JRadioButton("SAVINGS ACCOUNT");
r1.setBounds(100,180,250,20);
r1.setFont(new Font("Raleway", Font.BOLD, 16));
add(r1);
r1.setBackground(Color.WHITE);

r2 = new JRadioButton("FIXED DEPOSIT ACCOUNT");
r2.setBounds(350,180,250,20);
r2.setFont(new Font("Raleway", Font.BOLD, 16));
add(r2);
r2.setBackground(Color.WHITE);

r3 = new JRadioButton("CURRENT ACCOUNT");
r3.setBounds(100,220,250,20);
r3.setFont(new Font("Raleway", Font.BOLD, 16));
add(r3);
r3.setBackground(Color.WHITE);

r4 = new JRadioButton("RECURRING ACCOUNT");
r4.setBounds(350,220,250,20);
r4.setFont(new Font("Raleway", Font.BOLD, 16));
add(r4);
r4.setBackground(Color.WHITE);

getContentPane().setBackground(Color.WHITE);

ButtonGroup accountype = new ButtonGroup();
accountype.add(r1);
accountype.add(r2);
accountype.add(r3);
accountype.add(r4);

JLabel Cardno = new JLabel("CARD NUMBER:");
Cardno.setFont(new Font("Raleway", Font.BOLD, 22));
Cardno.setBounds(100,300,200,30);
add(Cardno);

JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
number.setFont(new Font("Raleway", Font.BOLD, 22));
number.setBounds(330,300,300,30);
add(number);

JLabel details = new JLabel("THIS IS YOUR 16 DIGIT CARD NUMBER");
details.setFont(new Font("Raleway", Font.BOLD, 12));
details.setBounds(100,330,300,20);
add(details);




JLabel PIN = new JLabel("PIN:");
PIN.setFont(new Font("Raleway", Font.BOLD, 22));
PIN.setBounds(100,370,200,30);
add(PIN);
JLabel PINdetails = new JLabel("THIS IS YOUR 4 DIGIT CARD PIN");
PINdetails.setFont(new Font("Raleway", Font.BOLD, 12));
PINdetails.setBounds(100,400,300,20);
add(PINdetails);



JLabel pinnum = new JLabel("XXXX");
pinnum.setFont(new Font("Raleway", Font.BOLD, 22));
pinnum.setBounds(330,370,300,30);
add(pinnum);



JLabel service = new JLabel("SERVICES REQUIRED");
service.setFont(new Font("Raleway", Font.BOLD, 22));
service.setBounds(100,450,300,20);
add(service);



c1 = new JCheckBox("ATM CARD");
c1.setBounds(100,500,200,30);
c1.setFont(new Font("Raleway", Font.BOLD, 16));
add(c1);
c1.setBackground(Color.WHITE);

c2 = new JCheckBox("INTERNET BANKING");
c2.setBounds(350,500,200,30);
c2.setFont(new Font("Raleway", Font.BOLD, 16));
add(c2);
c2.setBackground(Color.WHITE);


c4 = new JCheckBox("MOBILE BANKING");
c4.setBounds(100,550,200,30);
c4.setFont(new Font("Raleway", Font.BOLD, 16));
add(c4);
c4.setBackground(Color.WHITE);


c4 = new JCheckBox("EMAIL/SMS ALERTS");
c4.setBounds(350,550,200,30);
c4.setFont(new Font("Raleway", Font.BOLD, 16));
add(c4);
c4.setBackground(Color.WHITE);


c5 = new JCheckBox("CHEQUE BOOK");
c5.setBounds(100,600,200,30);
c5.setFont(new Font("Raleway", Font.BOLD, 16));
add(c5);
c5.setBackground(Color.WHITE);


c6 = new JCheckBox("E-STATEMENTS");
c6.setBounds(350,600,200,30);
c6.setFont(new Font("Raleway", Font.BOLD, 16));
add(c6);
c6.setBackground(Color.WHITE);


c7 = new JCheckBox("I hereby declares that the above entered etails are co");
c7.setBounds(100,680,700,30);
c7.setFont(new Font("Raleway", Font.BOLD, 12));
add(c7);
c7.setBackground(Color.WHITE);




submit = new JButton("SUBMIT");
submit.setBackground(Color.BLACK);
submit.setForeground(Color.WHITE);
submit.setFont(new Font("Raleway", Font.BOLD, 14));
submit.setBounds(250,720,100,30);
submit.addActionListener(this);

add(submit);

cancel = new JButton("CANCEL");
cancel.setBackground(Color.BLACK);
cancel.setForeground(Color.WHITE);
cancel.setFont(new Font("Raleway", Font.BOLD, 14));
cancel.setBounds(420,720,100,30);
cancel.addActionListener(this);//

add(cancel);

setSize(850,800);
setLayout(null);
setVisible(true);
setLocation(350,200);
setTitle("REGISTER");
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==submit){
String acctype = null;
if(r1.isSelected()){
acctype="Savings";
}

else if(r2.isSelected()){
acctype="FIXED";
}

else if(r3.isSelected()){
acctype="CURRENT";
}

else if(r4.isSelected()){
acctype="RECURRING";
}
Random r = new Random();
String cardnumber = "" + Math.abs((r.nextLong()%90000000L)+5040936000000000L);

String pinnumber = "" + Math.abs((r.nextLong()%9000L)+1000L);


String facility=null;
if(c1.isSelected()){
facility = facility + " ATM CARD";
}
else if(c2.isSelected()){
facility = facility + " INTERNET BANKING";
}
else if(c3.isSelected()){
facility = facility + " MOBILE BANKING";
}
else if(c4.isSelected()){
facility = facility + " EMAIL/SMS ALERTS";
}
else if(c5.isSelected()){
facility = facility + " CHEQUE BOOK";
}
else if(c6.isSelected()){
facility = facility + " E-STATEMENT";
}


try{
if(acctype.equals("")){
JOptionPane.showMessageDialog(null,"ACCOUNT TYPE IS REUQIRED");
}
else{
Conn conn = new Conn();
String query = "insert into signupthree values('"+formno+"','"+acctype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";

String query2 = "insert into Login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
conn.s.executeUpdate(query);
conn.s.executeUpdate(query2);
JOptionPane .showMessageDialog(null,"cardnumber:"+cardnumber+"\n pinnumber:"+pinnumber);
setVisible(false);
new Deposit(pinnumber).setVisible(true);
}
}
catch(Exception e){
System.out.println(e);
}



}
else if(ae.getSource()==cancel){
setVisible(false);
new Login.setVisible(true);

}





}
public static void main(String args[]){
new SignupThree("");
}}