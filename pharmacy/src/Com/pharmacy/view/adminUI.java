package Com.pharmacy.view;

import Com.pharmacy.controller.LoginDAO;
import Com.pharmacy.model.Login;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class adminUI implements ActionListener {
        JFrame frame;	
        JLabel l1, l2, l3, l4;
	 JTextField tf1;
	 JButton btn1;
	 JPasswordField p1;
	public adminUI() {

		
		frame = new JFrame("Add Admin");
		  frame.setLayout(null);
			  frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		l1 = new JLabel("<HTML><U>Enter user credientals</U></HTML>");
		 
		  
		  l2 = new JLabel("Enter Username");
		  l3 = new JLabel("Enter Password");
		  tf1 = new JTextField();
		  p1 = new JPasswordField();
		  btn1 = new JButton("Save");
		 
		  l4=new JLabel("This is one time process so keep your credientals safe.");
		  l4.setForeground(Color.red);
		
		  
		  //l4.setFont(new Font("Serif", Font.BOLD, 20));
		 
		  //l1.setBounds(x, y, width, height);
		  l1.setBounds(130, 70, 400, 30);
		  l2.setBounds(70, 110, 120, 30);
		  l3.setBounds(70, 150, 120, 30);
		  tf1.setBounds(210, 110, 150, 30);
		  p1.setBounds(210, 150, 150, 30);
		  btn1.setBounds(150, 200, 100, 30);
		  l4.setBounds(60, 300, 350, 30);

		  
		  frame.add(l1);
		  frame.add(l2);
		  frame.add(tf1);
		  frame.add(l3);
		  frame.add(p1);
		  frame.add(btn1);
                  frame.add(l4);
		  frame.setSize(450, 470);
		  
                  btn1.addActionListener(this);
            
                  frame.setVisible(true);
                  
                  
                  
		 }

    @Override
    public void actionPerformed(ActionEvent e) {

        String uname=tf1.getText();
        char[] pass=p1.getPassword();
        String password=String.valueOf(pass);
        
        if(uname.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(null, "Fill all the fields");
            
        }else{
            Login ob= new Login();
            ob.setUsername(uname);
            ob.setPassword(password);
            
            LoginDAO dao= new LoginDAO();
            dao.AddUser(ob);
            JOptionPane.showMessageDialog(null, "Credientials added");
        frame.dispose();
            Com.pharmacy.view.LoginUser newf1= new Com.pharmacy.view.LoginUser();
            newf1.setVisible(true);
            
        }
        

    }
		
		
		
		
		
		
	}


