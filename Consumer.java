import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
class Consumer extends JFrame implements ActionListener
{
    JLabel l0,l1,l2;
    JTextField tf1,tf2;
    JButton b1,b2,b3;
    Consumer()
    {
        setTitle("Consumer");
        setVisible(true);
        setSize(700,700);
        setLayout(null);
        l0=new JLabel("Search for Products");
        l1=new JLabel("Enter item:");
        tf1=new JTextField(20);
        l2=new JLabel("Available:");
        tf2=new JTextField(20);
        b1=new JButton("Search");
        b2=new JButton("Clear");
        b3=new JButton("Home");
        Font f=new Font(Font.MONOSPACED, Font.BOLD, 30);
        l0.setFont(f);
        b1.setBackground(Color.green);
        b2.setBackground(Color.yellow);
        b3.setBackground(Color.orange);
        l1.setFont(new Font(Font.DIALOG, Font.BOLD+ Font.ITALIC, 20));
        l2.setFont(new Font(Font.DIALOG, Font.BOLD+ Font.ITALIC, 20));
        b1.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        b2.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        b3.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        tf1.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,20));
        tf2.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,20));
        l0.setForeground(Color.orange);
        l0.setBounds(200,40,400,100);
        l1.setBounds(140,200,160,40);
        tf1.setBounds(255,200,200,40);
        l2.setBounds(140,300,160,40);
        tf2.setBounds(255,300,200,40);
        b1.setBounds(480,200,100,40);
        b2.setBounds(480,300,100,40);
        b3.setBounds(250,400,200,40);
        add(l0);add(l1);add(tf1);add(b1);add(l2);add(tf2);add(b2);add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        Object obj=ae.getSource();
        if(obj==b1)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartMart","root","klm18504");
                Statement st = con.createStatement();
                String query = "select * from items";
                ResultSet rs=st.executeQuery(query);
                int flag=0;
                while(rs.next())
                {
                    String item=tf1.getText();
                    String search=rs.getString(1);
                    if(item.equals(search))
                    {
                        int q=Integer.parseInt(rs.getString(3));
                        if(q==0)
                        {
                            JOptionPane.showMessageDialog(null,"Stock unavailable");
                        }
                        else
                        {
                            tf2.setText(""+q);
                        }
                        flag=1;
                    }
                }
                if(flag==0)
                {
                    JOptionPane.showMessageDialog(null,"Product not found");
                }
            }
            catch(Exception e) {}
        }
        if(obj==b2)
        {
            tf1.setText("");
            tf2.setText("");
        }
        if(obj==b3)
        {
            new ProducerConsumer();
        }
    }
}
