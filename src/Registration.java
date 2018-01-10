/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dativa
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Registration extends JFrame implements ActionListener {
    
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/guijava";

    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField tf1, tf2, tf5, tf6, tf7;
    private JButton btn1, btn2;
    JPasswordField p1,p2;
    
    
    
    Registration(){
        
        setSize(600, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registration");
           
        l1= new JLabel("Registration Form");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif",Font.BOLD,20));
             
        l2= new JLabel("Name:");
        l3=new JLabel("Email-ID:");
        l4=new JLabel("Create Password");
        l5=new JLabel("Confirm Your Password");
        l6=new JLabel("Country");
        l7=new JLabel("State");
        l8=new JLabel("Phone Number");
              
        tf1=new JTextField();
        tf2=new JTextField();
        
        p1=new JPasswordField();
        p2=new JPasswordField();
        
        tf5=new JTextField();
        tf6=new JTextField();
        tf7=new JTextField();
        
        
        btn1=new JButton("Submit");
        btn1.addActionListener(this);
        btn2=new JButton("Clear");
        btn2.addActionListener(this);
        
        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 230, 200, 30);
        l7.setBounds(80, 270, 200, 30);
        l8.setBounds(80, 310, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        tf2.setBounds(300, 110, 200, 30);
        p1.setBounds(300, 150, 200, 30);
        p2.setBounds(300, 190, 200, 30);
        tf5.setBounds(300, 230, 200, 30);
        tf6.setBounds(300, 270, 200, 30);
        tf7.setBounds(300, 310, 200, 30);
        btn1.setBounds(80, 350, 100, 30);
        btn2.setBounds(200, 350, 100, 30);
        
        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(l4);
        add(p1);
        add(l5);
        add(p2);
        add(l6);
        add(tf5);
        add(l7);
        add(tf6);
        add(l8);
        add(tf7);
        add(btn1);
        add(btn2);
               setVisible(true);
    }
    

    Connection conn = null;
    Statement stmt = null;
 //  Database credentials
   static final String USER = "root";
   static final String PASS = "";

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); 
        
        String get= e.getActionCommand();
          if(get.equals("Submit")){
             insert();
            // clear text field after submit
             clearTextField();
             
       
          } else if(get.equals("Clear")){
              clearTextField();
       }
    }
    
    public void insert()
{   
    try {
    // connection string
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/guijava?user=root&password=");
        
        Statement st = con.createStatement();

        st.executeUpdate("insert into student_details VALUES(null,'"
                + tf1.getText() + "','" + tf2.getText() + "','"
                + p1.getText() + "','" + tf5.getText()
                + "','" + tf6.getText() + "','" + tf7.getText()
           + "')");

        JOptionPane.showConfirmDialog(null, "Your Data Has been Inserted",
                "Result", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        st.close();
        con.close();
        
        

    }

    catch (Exception e1)

    {
        System.out.println("Exception:" + e1);
    }

}
  
    public void clearTextField(){
        
        tf1.setText(null);
        tf2.setText("");
        p1.setText("");
        p2.setText("");
        tf5.setText("");
        tf6.setText("");
        tf7.setText("");
     


        
   
        
        
    }
    
    
    
    
    
}
    
   
    
    

