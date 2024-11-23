import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class LoginPage extends JFrame implements ActionListener
{
    JButton b1,b2;
    JLabel l0,l1,l2,l3;
    JTextField tf1;
    JPasswordField tf2;
    LoginPage()
    {
        setTitle("Login page");
        setVisible(true);
        setSize(700,700);
        setLayout(null);
        l0=new JLabel("ENTER USER CREDENTIALS");
        l1=new JLabel("Username:");
        l2=new JLabel("Password:");
        l3=new JLabel("");
        tf1=new JTextField(20);
        tf2=new JPasswordField(20);
        b1=new JButton("Login");
        b2=new JButton("Clear");
        b1.setBackground(Color.cyan);
        b2.setBackground(Color.magenta);
        Font f=new Font(Font.MONOSPACED, Font.BOLD, 30);
        l0.setFont(f);
        l1.setFont(new Font(Font.DIALOG, Font.BOLD+ Font.ITALIC, 20));
        l2.setFont(new Font(Font.DIALOG, Font.BOLD+ Font.ITALIC, 20));
        b1.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        b2.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        l3.setFont(new Font("Serif", Font.BOLD, 20));
        tf1.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,20));
        tf2.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,20));
        l0.setBounds(150,40,400,100);
        l0.setForeground(Color.orange);
        l1.setBounds(120,200,110,40);
        tf1.setBounds(250,200,200,40);
        l2.setBounds(120,300,100,40);
        tf2.setBounds(250,300,200,40);
        l3.setBounds(300,500,100,40);
        b1.setBounds(150,390,200,40);
        b2.setBounds(370,390,200,40);
        add(l0);add(l1);add(tf1);add(l2);add(tf2);add(b1);add(b2);add(l3);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        Object b=ae.getSource();
        if(b==b1)
        {
            String user=tf1.getText();
            String password=tf2.getText();
            if(user.equals("Admin")&& password.equals("root"))
            {
                new Producer();
            }
            else
            {
                l3.setText("Invalid user");
            }
        }
        if(b==b2)
        {
            tf1.setText("");
            tf2.setText("");
            l3.setText("");
        }
    }
}
        