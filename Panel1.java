import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Panel1 extends JFrame
{
    private ImageIcon rulepic=new ImageIcon();
    private JLabel Question;
    private JLabel Times;
    private JLabel plus;
    private JLabel minus;
    private JLabel multiply;
    private JLabel divide;
    private JLabel NScore;
    private Play right,wrong;
    private static Score1 score;
    private static Q que;
    private int TT=30;
    public void setVis(boolean b){setVisible(b);}
    NTime now=new NTime();
    Timer timer =new Timer(1000,now);
    class NTime extends JFrame implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            TT--;
            Times.setText(TT+"s");
            if(TT==0)
            {
                timer.stop();
                setVis(false);
                result3 res=new result3(score);
            }
        }
    }
    public Panel1()
    {
        super("加減乘除"); 
        Container c = getContentPane(); 
        c.setLayout(null);
        right=new Play("crrect.mp3");
        wrong=new Play("wrong.mp3");
        
        timer.start();
        plus=new JLabel(new ImageIcon("plus.jpg"));
        plus.setLocation(93,200);
        plus.setSize(98,98);
        plus.addMouseListener(new MouseClickP());
        c.add(plus);
        minus=new JLabel(new ImageIcon("minus.jpg"));
        minus.setLocation(203,200);
        minus.setSize(98,98);
        minus.addMouseListener(new MouseClickM());
        c.add(minus);
        multiply=new JLabel(new ImageIcon("multiply.jpg"));
        multiply.setLocation(93,310);
        multiply.setSize(98,98);
        multiply.addMouseListener(new MouseClickMu());
        c.add(multiply);
        divide=new JLabel(new ImageIcon("divide.jpg"));
        divide.setLocation(203,310);
        divide.setSize(98,98);
        divide.addMouseListener(new MouseClickD());
        c.add(divide);
        
        score=new Score1();
        que=new Q();
        que.row();
        //設定Jlb_ID大小位置及顯示字型
        Question = new JLabel();
        Question.setText(que.get());
        Question.setLocation(-50,100);
        Question.setSize(500,100);
                              //這裡改字型
        Question.setFont(new Font("Serif",Font.BOLD,45));
        Question.setHorizontalAlignment(JTextField.CENTER);
        c.add(Question);
        
        //設定Jlb_ID大小位置及顯示字型
        Times=new JLabel("30s");
        Times.setLocation(122,30);
        Times.setSize(150,75);
        Times.setFont(new java.awt.Font("dialog",0,36));
        Times.setHorizontalAlignment(JTextField.CENTER);
        c.add(Times);
        NScore = new JLabel("Score:0");
        NScore.setLocation(0,0);
        NScore.setSize(150,75);
        NScore.setForeground(new Color(0,0,153,150));
                              //這裡改字型
        NScore.setFont(new Font("Serif",Font.BOLD,30));
        c.add(NScore);
        setSize(400,600);
        setLocation(258,175);
        
        this.getContentPane().setBackground(Color.GRAY.brighter());
        this.getContentPane().setVisible(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    class MouseClickP extends MouseAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            if(que.getAns()==0){score.add(true);right.p();}
            else{score.add(false);wrong.p();}
            que.row();
            Question.setText(que.get());
            NScore.setText("score:"+score.getScore());
        }
    }
    class MouseClickM extends MouseAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            if(que.getAns()==1){score.add(true);right.p();}
            else{score.add(false);wrong.p();}
            que.row();
            Question.setText(que.get());
            NScore.setText("score:"+score.getScore());
        }
    }
    class MouseClickMu extends MouseAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            if(que.getAns()==2){score.add(true);right.p();}
            else{score.add(false);wrong.p();}
            que.row();
            Question.setText(que.get());
            NScore.setText("score:"+score.getScore());
        }
    }
    class MouseClickD extends MouseAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            if(que.getAns()==3){score.add(true);right.p();}
            else{score.add(false);wrong.p();}
            que.row();
            Question.setText(que.get());   
            NScore.setText("score:"+score.getScore());
        }
    }
}