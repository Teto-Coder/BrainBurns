import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class result3 extends JFrame
{
    result3(Score1 p1)
    {
        this.getContentPane().setBackground(Color.GRAY.brighter());
        this.getContentPane().setVisible(true);
        
        JLabel label1=new JLabel("GameOver");
        label1.setFont(new java.awt.Font("dialog",0,52));
        label1.setHorizontalAlignment(JTextField.CENTER);
        label1.setBounds(35,24,442,77);
        add(label1);
        
        JLabel label2=new JLabel("答對題數:"+p1.getCorrect());
        label2.setFont(new java.awt.Font("dialog",0,20));
        label2.setBounds(67,128,363,33);
        add(label2);
        
        JLabel label3=new JLabel("答錯題數:"+p1.getMiss());
        label3.setFont(new java.awt.Font("dialog",0,20));
        label3.setBounds(67,176,325,33);
        add(label3);
        
        JLabel label5=new JLabel("分數:"+p1.getScore());
        label5.setFont(new java.awt.Font("dialog",0,20));
        label5.setBounds(67,232,363,33);
        add(label5);
        
        setTitle("Result");
        setLayout(null);
        setBounds(100,100,516,396);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}