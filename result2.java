import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class result2 extends JFrame
{
    result2(Score2 p1,String ans,String playerans)
    {
        Color lightBlue= new Color(56,134,228,255);
        this.getContentPane().setBackground(lightBlue);
        this.getContentPane().setVisible(true);
        
        JLabel label1=new JLabel("GameOver");
        label1.setFont(new java.awt.Font("dialog",0,52));
        label1.setBounds(35,24,442,77);
        label1.setHorizontalAlignment(JTextField.CENTER);
        add(label1);
        
        JLabel label2=new JLabel("正確答案:"+ans);
        label2.setFont(new java.awt.Font("dialog",0,20));
        label2.setBounds(67,128,363,33);
        add(label2);
        
        JLabel label3=new JLabel("你的答案:"+playerans);
        label3.setFont(new java.awt.Font("dialog",0,20));
        label3.setBounds(67,176,325,33);
        add(label3);
        
        JLabel label4=new JLabel("成功記住的位數:"+p1.getX());
        label4.setFont(new java.awt.Font("dialog",0,20));
        label4.setBounds(67,232,363,33);
        add(label4);
        
        JLabel label5=new JLabel("分數:"+p1.getScore());
        label5.setFont(new java.awt.Font("dialog",0,20));
        label5.setBounds(67,282,363,33);
        add(label5);
        
        setTitle("Result");
        setLayout(null);
        setBounds(100,100,516,396);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}