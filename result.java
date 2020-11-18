import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class result extends JFrame{
    result(score p1,score p2){
        JLabel label1,label2,label3,label4,label5;
        String win=new String();
        int flag=0;
        if(p1.cnt>p2.cnt){
            win=new String("PLAY1");
        }
        else if(p2.cnt>p1.cnt){
            win=new String("PLAY2");
        }
        else{
            flag=1;
        }
        if(flag==1)label1=new JLabel("平局");
        else label1=new JLabel("Winner : "+win);
        label1.setFont(new java.awt.Font("dialog",0,48));
        label1.setBounds(35,24,442,77);
        label1.setForeground(Color.RED);
        add(label1);
        label2=new JLabel("PLAY1 答對:"+p1.DirCorrect+"次 答錯:"+p1.DirWrong+"次");
        label2.setFont(new java.awt.Font("dialog",0,20));
        label2.setBounds(67,128,363,33);
        add(label2);
        label3=new JLabel("正確率:"+p1.rate+"% 得分:"+p1.cnt+"分");
        label3.setFont(new java.awt.Font("dialog",0,20));
        label3.setBounds(67,176,325,33);
        add(label3);
        label4=new JLabel("PLAY2 答對:"+p2.DirCorrect+"次 答錯:"+p2.DirWrong+"次");
        label4.setFont(new java.awt.Font("dialog",0,20));
        label4.setBounds(67,232,363,33);
        add(label4);
        label5=new JLabel("正確率:"+p2.rate+"% 得分:"+p2.cnt+"分");
        label5.setFont(new java.awt.Font("dialog",0,20));
        label5.setBounds(67,280,325,33);
        add(label5);
        setTitle("Result");
        setLayout(null);
        setBounds(100,100,516,396);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}