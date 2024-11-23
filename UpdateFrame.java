import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
class UpdateFrame extends JFrame implements ActionListener
{
    JLabel l0,l1,l2,l3;
    JTextField tf1,tf2,tf3;
    JButton b1,b2,b3,b4;
    UpdateFrame()
    {
        setTitle("Producer");
        setVisible(true);
        setSize(700,700);
        setLayout(null);
        l0=new JLabel("Update Products");
        l1=new JLabel("Item Name:");
        tf1=new JTextField(20);
        l2=new JLabel("Update Price:");
        tf2=new JTextField(20);
        l3=new JLabel("Update Amount:");
        tf3=new JTextField(20);
        b1=new JButton("Update cost");
        b2=new JButton("Update amount");
        b3=new JButton("Home");
        b4=new JButton("Clear");
        Font f=new Font(Font.MONOSPACED, Font.BOLD, 30);
        l0.setFont(f);
        b1.setBackground(Color.green);
        b2.setBackground(Color.yellow);
        b3.setBackground(Color.orange);
        b4.setBackground(Color.orange);
        l1.setFont(new Font(Font.DIALOG, Font.BOLD+ Font.ITALIC, 20));
        l2.setFont(new Font(Font.DIALOG, Font.BOLD+ Font.ITALIC, 20));
        l3.setFont(new Font(Font.DIALOG, Font.BOLD+ Font.ITALIC, 20));
        b1.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        b2.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        b3.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        b4.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        tf1.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,20));
        tf2.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,20));
        tf3.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,20));
        l0.setForeground(Color.orange);
        l0.setBounds(200,40,400,100);
        l1.setBounds(70,200,160,40);
        tf1.setBounds(240,200,200,40);
        l2.setBounds(70,300,160,40);
        tf2.setBounds(240,300,200,40);
        l3.setBounds(70,400,160,40);
        tf3.setBounds(240,400,200,40);
        b1.setBounds(460,300,200,40);
        b2.setBounds(460,400,200,40);
        b3.setBounds(150,550,200,40);
        b4.setBounds(400,550,200,40);
        add(l0);add(l1);add(tf1);add(b1);add(l2);add(tf2);add(b2);add(l3);add(tf3);add(b3);add(b4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        Object ob=ae.getSource();
        if(ob==b1)
        {
            try
            {
                String it=tf1.getText();
                String pr=tf2.getText();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartMart","root","klm18504");
                PreparedStatement ps=con.prepareStatement("update items set Price=? where Item=?");
                ps.setString(1,pr);
                ps.setString(2,it);
                int x=ps.executeUpdate();
                if(x==1)
                {
                    JOptionPane.showMessageDialog(null,"Price Updated");
                }
            }
            catch(Exception e) {}
        }
        if(ob==b2)
        {
            try
            {
                String it=tf1.getText();
                String am=tf3.getText();
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartMart","root","klm18504");
                PreparedStatement ps=con.prepareStatement("update items set Quantity=? where Item=?");
                ps.setString(1,am);
                ps.setString(2,it);
                int x=ps.executeUpdate();
                if(x==1)                {
                    JOptionPane.showMessageDialog(null,"Quantity Updated");
                }
            }
            catch(Exception e) {}
        }
        if(ob==b3)
        {
            new ProducerConsumer();
        }
    }
}
