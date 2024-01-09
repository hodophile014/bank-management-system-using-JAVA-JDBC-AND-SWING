import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;


class signUptwo extends JFrame implements ActionListener{

JTextField PAN,AADHAR;
JButton next;
JComboBox RELIGIONS, CATEGORY, INCOME,OCCUPATION,EDUCATION;
JRadioButton yes,no,eyes,eno;
String formNo;
signUptwo(String formNo){
this.formNo = formNo;

setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2");


getContentPane().setBackground(Color.WHITE);


JLabel addDetails = new JLabel("PAGE 2: ADDITIONAL DETAILS");
addDetails.setFont(new Font("Raleway", Font.BOLD, 22));
addDetails.setBounds(290,80,400,30);
add(addDetails);

JLabel religion = new JLabel("RELIGION:");
religion.setFont(new Font("Raleway", Font.BOLD, 22));
religion.setBounds(100,140,200,30);
add(religion);

String[] valrel = {"Hindu","Muslim","Sikh","Christian","other"};
RELIGIONS = new JComboBox(valrel);
RELIGIONS.setBounds(400,140,400,30);
add(RELIGIONS);



JLabel category= new JLabel("CATEGORY:");
category.setFont(new Font("Raleway", Font.BOLD, 22));
category.setBounds(100,190,200,30);
add(category);

String[] valcat = {"General","OBC","SC","ST","OTHER"};
CATEGORY = new JComboBox(valcat);
CATEGORY.setBounds(400,190,400,30);
CATEGORY.setBackground(Color.WHITE);
add(CATEGORY);

JLabel income = new JLabel("INCOME:");
income.setFont(new Font("Raleway", Font.BOLD, 22));
income.setBounds(100,240,200,30);
add(income);


String[] valinc = {"null","< 1,50,000","< 2,50,000","< 5,00,000","< 10,00,000"};
INCOME = new JComboBox(valinc);
INCOME.setBounds(400,240,400,30);
INCOME.setBackground(Color.WHITE);
add(INCOME);





JLabel education = new JLabel("EDUCATION:");
education.setFont(new Font("Raleway", Font.BOLD, 22));
education.setBounds(100,290,200,30);
add(education);


String[] valedu = {"NON-GRADUATE","GRADUATE","POST-GRADUATE","DOCTORATE","OTHER"};
EDUCATION = new JComboBox(valedu);
EDUCATION.setBounds(400,290,400,30);
EDUCATION.setBackground(Color.WHITE);
add(EDUCATION);




JLabel qualify = new JLabel("QUALIFICATION");
qualify.setFont(new Font("Raleway", Font.BOLD, 22));
qualify.setBounds(100,315,200,30);
add(qualify);





JLabel occupation = new JLabel("OCCUPATION:");
occupation.setFont(new Font("Raleway", Font.BOLD, 22));
occupation.setBounds(100,390,200,30);
add(occupation);

String[] valocu = {"SALARIED","SELF-EMPLOYED","BUSINESS","STUDENT","RETIRED","OTHERS"};
 OCCUPATION = new JComboBox(valocu);
OCCUPATION.setBounds(400,390,400,30);
OCCUPATION.setBackground(Color.WHITE);
add(OCCUPATION);




JLabel pan = new JLabel("PAN NUMBER:");
pan.setFont(new Font("Raleway", Font.BOLD, 22));
pan.setBounds(100,440,200,30);
add(pan);
PAN = new JTextField();
PAN.setFont(new Font("Raleway", Font.BOLD,14));
PAN.setBounds(400,440,400,30);
add(PAN);


JLabel aadhar= new JLabel("AADHAR NUMBER:");
aadhar.setFont(new Font("Raleway", Font.BOLD, 22));
aadhar.setBounds(100,490,250,30);
add(aadhar);

AADHAR = new JTextField();
AADHAR.setFont(new Font("Raleway", Font.BOLD,14));
AADHAR.setBounds(400,490,400,30);
add(AADHAR);




JLabel senior = new JLabel("SENIOR CITIZEN?:");
senior.setFont(new Font("Raleway", Font.BOLD, 22));
senior.setBounds(100,540,200,60);
add(senior);
yes = new JRadioButton("YES");
yes.setBounds(450,540,50,30);
add(yes);
yes.setBackground(Color.WHITE);
no = new JRadioButton("no");
no.setBounds(500,540,50,30);
add(no);
no.setBackground(Color.WHITE);

ButtonGroup m = new ButtonGroup();
m.add(yes);
m.add(no);






JLabel exist = new JLabel("EXISTING ACCOUNT IN OUR BANK?:");
exist.setFont(new Font("Raleway", Font.BOLD, 22));
exist.setBounds(100,590,200,30);
add(exist);
eyes = new JRadioButton("YES");
eyes.setBounds(450,590,50,30);
add(eyes);
eyes.setBackground(Color.WHITE);
eno = new JRadioButton("no");
eno.setBounds(500,590,50,30);
add(eno);
eno.setBackground(Color.WHITE);
ButtonGroup ex = new ButtonGroup();
ex.add(eyes);
ex.add(eno);






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
String r = (String) RELIGIONS.getSelectedItem();
String c = (String) CATEGORY.getSelectedItem();
String i = (String) INCOME.getSelectedItem();
String e = (String) EDUCATION.getSelectedItem();
String o = (String) OCCUPATION.getSelectedItem();
String sen = null;
if(yes.isSelected()){
sen = "yes";}
else if(no.isSelected()){
sen = "No";}

String exi = null;
if(eyes.isSelected()){
exi = "yes";}
else if(eno.isSelected()){
exi = "no";}
String span = PAN.getText();
String sa = AADHAR.getText();
try{
Conn con = new Conn();
String query = "insert into signuptwo values('"+formNo+"','"+r+"','"+c+"','"+i+"','"+e+"','"+o+"','"+sen+"','"+exi+"','"+span+"','"+sa+"')";
con.s.executeUpdate(query);



setVisible(false);
new SignupThree(formNo).setVisible(true);

}
catch(Exception ex){
System.out.println(ex);
}


}

public static void main(String args[]){
new signUptwo("");
}
}