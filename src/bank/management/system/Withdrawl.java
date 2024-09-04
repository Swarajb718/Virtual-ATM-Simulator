package bank.management.system;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount;
    JLabel text;
    JButton withdraw,back;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        
        setLayout(null);
        
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        text = new JLabel("ENTER AMOUNT YOU WANT TO Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(160,10, 900, 600);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
     
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    
     public void actionPerformed(ActionEvent ae){
               
            if(ae.getSource()==withdraw){
                String number = amount.getText();
            Date date = new Date();
            
                if(number.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to withdraw");
                }else{
                       try{ 
                    Conn conn = new Conn();
                    String query="insert into bank values('"+pinnumber+"', '"+date+"', 'withdrawl', '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+number+" withdrawn Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                
                    }catch(Exception e){
                         System.out.println(e);
                    }     
                 }
            }else if(ae.getSource()== back){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        }
    
    public static void main(String args[]){
        new Withdrawl("");
    }
    
}