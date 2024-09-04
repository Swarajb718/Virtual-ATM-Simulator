package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl, ministatement, pinchange,fastcash,balanceenquiry, exit;
    String pinnumber ;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,-100,700,800);
        add(image);
        
        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(175,300,700,35);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("System",Font.BOLD,12));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,375,90,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
         withdrawl = new JButton("Cash Withdraw");
        withdrawl.setBounds(290,375,110,20);
        withdrawl.setFont(new Font("System",Font.BOLD,10));
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
         fastcash= new JButton("Fast Cash");
        fastcash.setBounds(170,400,90,20);
        fastcash.setFont(new Font("System",Font.BOLD,10));
        fastcash.addActionListener(this);
        image.add(fastcash);
        
         ministatement= new JButton("Mini Statement");
        ministatement.setBounds(290,400,110,20);
        ministatement.addActionListener(this);
        ministatement.setFont(new Font("System",Font.BOLD,10));
        image.add(ministatement);
        
         pinchange= new JButton("Pin Change");
        pinchange.setBounds(170,425,90,20);
        pinchange.setFont(new Font("System",Font.BOLD,10));
        pinchange.addActionListener(this);
        
        image.add(pinchange);
        
         balanceenquiry= new JButton("Balance Enquiry");
        balanceenquiry.setBounds(290,425,110,20);
        balanceenquiry.setFont(new Font("System",Font.BOLD,9));
        balanceenquiry.addActionListener(this);
        
        image.add(balanceenquiry);
        
         exit= new JButton("Exit");
        exit.setBounds(290,447,110,20);
        exit.setFont(new Font("System",Font.BOLD,10));
        exit.addActionListener(this);
        
        image.add(exit);
        
       setSize(900,900);
       setLocation(300,0);
       
       setVisible(true);
    
    
    
    
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if (ae.getSource()== deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
            }else if(ae.getSource()==withdrawl){  
                setVisible(false);
                new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
                    setVisible(false);
                    new FastCash(pinnumber).setVisible(true);
                }else if(ae.getSource()==pinchange){
                    setVisible(false);
                    new PinChange(pinnumber).setVisible(true);
                }else if(ae.getSource()== balanceenquiry){
                    setVisible(false);
                    new BalanceEnquiry(pinnumber).setVisible(true);
                }else if(ae.getSource()==ministatement){
                    new MiniStatement(pinnumber).setVisible(true);
                }
        
    }
    public static void main(String args[]){
        new Transactions("");
    }
    
}