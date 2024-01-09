import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;


class signUp extends JFrame implements ActionListener{
long n;
JTextField nameText,fnameText,emailText,addText,cityText,pinText,stateText;
JRadioButton male,female,married,unmarried,other;
JButton next;
signUp(){
Random ran = new Random();
n = Math.abs((ran.nextLong()%9000L)+1000L);


getContentPane().setBackground(Color.WHITE);

JLabel formNo = new JLabel("APPLICATION FORM NUMBER:"+n);
formNo.setFont(new Font("Raleway", Font.BOLD, 38));
formNo.setBounds(140,20,600,40);
add(formNo);

JLabel personalDetails = new JLabel("PAGE 1: PERSONAL DETAILS");
formNo.setFont(new Font("Raleway", Font.BOLD, 22));
formNo.setBounds(290,80,400,30);
add(formNo);

JLabel name = new JLabel("NAME:");
name.setFont(new Font("Raleway", Font.BOLD, 22));
name.setBounds(100,140,100,30);
add(name);

JLabel Fname = new JLabel("FATHER'S NAME:");
Fname.setFont(new Font("Raleway", Font.BOLD, 22));
Fname.setBounds(100,190,200,30);
add(Fname);

JLabel DOB = new JLabel("DATE OF BIRTH:");
DOB.setFont(new Font("Raleway", Font.BOLD, 22));
DOB.setBounds(100,240,200,30);
add(DOB);




JLabel Gender = new JLabel("GENDER:");
Gender.setFont(new Font("Raleway", Font.BOLD, 22));
Gender.setBounds(100,290,200,30);
add(Gender);

male = new JRadioButton("MALE");
male.setBounds(300,290,60,30);
add(male);
male.setBackground(Color.WHITE);

female = new JRadioButton("FEMALE");
female.setBounds(450,290,120,30);
add(female);
female.setBackground(Color.WHITE);

ButtonGroup gender = new ButtonGroup();
gender.add(male);
gender.add(female);






JLabel email = new JLabel("EMAIL ADDRESS:");
email.setFont(new Font("Raleway", Font.BOLD, 22));
email.setBounds(100,340,200,30);
add(email);

emailText = new JTextField();
emailText.setFont(new Font("Raleway", Font.BOLD,14));
emailText.setBounds(300,340,400,30);
add(emailText);




JLabel marital = new JLabel("MARITAL STATUS:");
marital.setFont(new Font("Raleway", Font.BOLD, 22));
marital.setBounds(100,390,200,30);
add(marital);

married = new JRadioButton("MARRIED");
married.setBounds(300,390,100,30);
add(married);
married.setBackground(Color.WHITE);

unmarried = new JRadioButton("UNAMRRIED");
unmarried.setBounds(450,390,100,30);
add(unmarried);
unmarried.setBackground(Color.WHITE);

other = new JRadioButton("OTHER");
other.setBounds(630,390,100,30);
add(other);
other.setBackground(Color.WHITE);


ButtonGroup m = new ButtonGroup();
m.add(married);
m.add(unmarried);
m.add(other);




JLabel Address = new JLabel("ADDRESS:");
Address.setFont(new Font("Raleway", Font.BOLD, 22));
Address.setBounds(100,440,200,30);
add(Address);

addText = new JTextField();
addText.setFont(new Font("Raleway", Font.BOLD,14));
addText.setBounds(300,440,400,30);
add(addText);



JLabel CITY = new JLabel("CITY:");
CITY.setFont(new Font("Raleway", Font.BOLD, 22));
CITY.setBounds(100,490,200,30);
add(CITY);
cityText = new JTextField();
cityText.setFont(new Font("Raleway", Font.BOLD,14));
cityText.setBounds(300,490,400,30);
add(cityText);




JLabel state = new JLabel("STATE:");
state.setFont(new Font("Raleway", Font.BOLD, 22));
state.setBounds(100,540,200,30);
add(state);
stateText = new JTextField();
stateText.setFont(new Font("Raleway", Font.BOLD,14));
stateText.setBounds(300,540,400,30);
add(stateText);



JLabel pin = new JLabel("PIN:");
pin.setFont(new Font("Raleway", Font.BOLD, 22));
pin.setBounds(100,590,200,30);
add(pin);
pinText = new JTextField();
pinText.setFont(new Font("Raleway", Font.BOLD,14));
pinText.setBounds(300,590,400,30);
add(pinText);





nameText = new JTextField();
nameText.setFont(new Font("Raleway", Font.BOLD,14));
nameText.setBounds(300,140,400,30);


add(nameText);

fnameText = new JTextField();
fnameText.setFont(new Font("Raleway", Font.BOLD,14));
fnameText.setBounds(300,190,400,30);
add(fnameText);



next = new JButton("NEXT");
next.setBackground(Color.BLACK);
next.setForeground(Color.WHITE);
next.setFont(new Font("Raleway", Font.BOLD, 14));
next.setBounds(620,660,80,30);
next.addActionListener(this);

add(next);

setSize(850,800);
setLayout(null);
setVisible(true);
setLocation(350,200);
setTitle("REGISTER");
}



public void actionPerformed(ActionEvent ae){
String formno = "" + n;
String name = nameText.getText();
String fname = fnameText.getText();
String gender= null;
if(male.isSelected()){
gender = "male";
}

else if(female.isSelected()){
gender ="female";
}

String email = emailText.getText();

String m  = null;
if(married.isSelected()){
m =  "married";
}
else if(unmarried.isSelected()){
m =  "unmarried";
}
if(other.isSelected()){
m =  "Other";
}

String address = addText.getText();
String city = cityText.getText();
String State = stateText.getText();
String pin = pinText.getText();
try{
if(name.equals("")){
JOptionPane.showMessageDialog(null,"name is required");
}
else{
Conn c = new Conn();
String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+gender+"','"+email+"','"+m+"','"+address+"','"+city+"','"+State+"','"+pin+"')";
c.s.executeUpdate(query);

setVisible(false);
new signUptwo(formno).setVisible(true);
}
}
catch(Exception e){
System.out.println(e);
}


}

public static void main(String args[]){
new signUp();
}
}