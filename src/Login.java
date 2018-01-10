
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.paint.Color.color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dativa
 */
public class Login  extends JFrame implements ActionListener{
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/guijava";

JLabel lusername, lpassword, l3;
JTextField usernameField;
JButton bt1;
JPasswordField passwordField;

Login(){
    setSize(350,350);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Login Form");
  
    
    lusername = new JLabel("Username");
    lpassword = new JLabel("Username");

    passwordField=new JPasswordField();
    
    
    bt1 = new JButton("login");
    bt1.addActionListener(this);
    
    
    usernameField = new JTextField();
    
    lusername.setBounds(50, 50, 80, 20);
    usernameField.setBounds(140,50,180,25);
    lpassword.setBounds(50,80,80, 20);
    passwordField.setBounds(140, 80,180,25);
    bt1.setBounds(140,120,100,25);
    

    add(lusername);
    add(usernameField);
    add(lpassword);
    add(passwordField);
    add(bt1);
    setVisible(true);

}


Connection conn =null;
Statement stmt =null;
//Set database Credentials;
static final String USER = "root";
static final String PASS ="";
    @Override
    public void actionPerformed(ActionEvent e) {
      
        String get = e.getActionCommand();
        
        if(get.equals("login")){
            
            selectUsers();
           
        }
        
    
   
        
    }
    
    public void selectUsers() {
  try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/guijava?user=root&password=");
        
        Statement st=conn.createStatement();
        String query = "SELECT * FROM users where username =" + "'" + usernameField.getText() + "' and password ="+"'"+passwordField.getText()+"'";
        
        ResultSet rs =st.executeQuery(query);
     if (rs.next())
            {
             
               MainActivity main = new MainActivity();
               main.setVisible(true);
               
              System.exit(0);
             
            }
            else
            {
                JOptionPane.showMessageDialog(null, "invalid username and password");
            }
       
  }
 
     catch (Exception e1)

    {
        System.out.println("Exception:" + e1);
    }
    
    }

}
