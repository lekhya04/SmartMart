import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
class Producer extends JFrame implements ActionListener
{
    JLabel l0,l1,l2,l3;
    JTextField tf1,tf2,tf3;
    JButton b1,b2,b3,b4;
    Producer()
    {
        setTitle("Producer frame");
        setSize(700,700);
        setVisible(true);
        setLayout(null);
        l0=new JLabel("ADD PRODUCTS");
        l1=new JLabel("Item Name:");
        l2=new JLabel("Price(per unit):");
        l3=new JLabel("Quantity:");
        tf1=new JTextField(20);
        tf2=new JTextField(20);
        tf3=new JTextField(20);
        b1=new JButton("Add item");
        b2=new JButton("Update item");  
        b3=new JButton("Clear");
        b4=new JButton("Home");
        b1.setBackground(Color.lightGray);
        b2.setBackground(Color.pink);
        b3.setBackground(Color.cyan);
        b4.setBackground(Color.orange);
        Font f=new Font(Font.MONOSPACED, Font.BOLD, 30);
        l0.setFont(f);
        l1.setFont(new Font(Font.DIALOG, Font.BOLD+ Font.ITALIC, 16));
        l2.setFont(new Font(Font.DIALOG, Font.BOLD+ Font.ITALIC, 16));
        l3.setFont(new Font(Font.DIALOG, Font.BOLD+ Font.ITALIC, 16));
        b1.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        b2.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        b3.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        b4.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        tf1.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,20));
        tf2.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,20));
        tf3.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,20));
        l0.setForeground(Color.orange);
        l0.setBounds(250,40,400,100);
        l1.setBounds(150,200,150,40);
        tf1.setBounds(250,200,200,40);
        l2.setBounds(140,300,190,40);
        tf2.setBounds(250,300,200,40);
        l3.setBounds(150,400,130,40);
        tf3.setBounds(250,400,200,40);
        b1.setBounds(50,480,150,40);
        b2.setBounds(250,480,150,40);
        b3.setBounds(450,480,150,40);
        b4.setBounds(250,550,150,40);
        add(l0);add(l1);add(tf1);add(l2);add(tf2);add(l3);add(tf3);add(b1);add(b2);add(b3);add(b4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae) 
    {
        Object o=ae.getSource();
        if(o==b1)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartMart","root","klm18504");
                Statement st=con.createStatement();
                String query="insert into items values('"+tf1.getText()+"',"+tf2.getText()+","+tf3.getText()+")";
                int x=st.executeUpdate(query);
                if(x==1)
                {
                    JOptionPane.showMessageDialog(null,"Item Added");
                }
            }
            catch(Exception e) {}
        }
        if(o==b2)
        {
            new UpdateFrame();
        }
        if(o==b3)
        {
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
        }
        if(o==b4)
        {
            new ProducerConsumer();
        }
    }
}