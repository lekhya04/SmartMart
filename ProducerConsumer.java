import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ProducerConsumer extends JFrame implements ActionListener
{
    JButton b1,b2;
    JLabel l1;
    ProducerConsumer()
    {
        b1=new JButton("Producer");
        b2=new JButton("Consumer");
        l1=new JLabel("WELCOME TO SMARTMART");
        l1.setForeground(Color.orange);
        setTitle("Login page");
        setVisible(true);
        setSize(700,700);
        this.setBackground(Color.blue);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        b1.setFont(new Font(Font.DIALOG, Font.ITALIC +Font.BOLD, 22));
        b2.setFont(new Font(Font.DIALOG, Font.ITALIC + Font.BOLD, 22));
        b1.setBackground(Color.green);
        b2.setBackground(Color.red);
        Font f=new Font("Serif", Font.BOLD, 40);
        l1.setFont(f);
        l1.setBounds(60,15,600,250);
        b1.setBounds(100,250,250,50);
        b2.setBounds(400,250,250,50);
        add(l1);add(b1);add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String s=ae.getActionCommand();
        if(s.equals("Producer"))
        {
            new LoginPage();
        }
    
        if(s.equals("Consumer"))
        {
            new Consumer();
        }
    }
    public static void main(String[] args) 
    {
        new ProducerConsumer();
    }
}
