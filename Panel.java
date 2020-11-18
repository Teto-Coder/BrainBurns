import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Panel extends JFrame
{
    private JLabel Jlb_ID = new JLabel();
    private JLabel NScore = new JLabel("Score:0");
    private JTextField jid = new JTextField();
    private JButton Jbtn_YES = new JButton("確定");
    private ButtonHandler hbtHandler = new ButtonHandler();  //處理按鈕事件 
    private static Score2 score;
    private Ans s=new Ans();
    Timer timer;
    class RUN extends JFrame implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            jid.setText("");
            jid.setVisible(true);
            Jlb_ID.setVisible(false);
            Jbtn_YES.setVisible(true);
            jid.requestFocus();
            timer.stop();
        }
    }
    public Panel()
    {
        super("數字記憶"); 
        score=new Score2();
        Jlb_ID.setText(s.getAns());
        Container c = getContentPane(); 
        c.setLayout(null);
        
        //設定Jlb_ID大小位置及顯示字型
        Jlb_ID.setLocation(47,30);
        Jlb_ID.setSize(300,75);
        Jlb_ID.setFont(new Font("Serif",Font.BOLD,30));
        Jlb_ID.setHorizontalAlignment(JTextField.CENTER);
        c.add(Jlb_ID);
        
        NScore.setLocation(10,0);
        NScore.setSize(150,75);
        NScore.setForeground(new Color(0,0,153,150));
        NScore.setFont(new Font("Serif",Font.BOLD,30));
        c.add(NScore);
        
        //設定帳號輸入框大小位置及顯示字型
        jid.setLocation(100,95);
        jid.setSize(200,40);
        jid.addKeyListener(new keymove());
        jid.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,18));
        jid.setHorizontalAlignment(JTextField.CENTER);
        c.add(jid);
        jid.setVisible(false);
                
        //設定確定按鈕大小位置及顯示字型
        Jbtn_YES.setLocation(160,145);
        Jbtn_YES.setSize(90,30);
        Jbtn_YES.addActionListener(hbtHandler);
        c.add(Jbtn_YES);
        Jbtn_YES.setVisible(false);
        
        setSize(400,300);
        setLocation(258,175);
        
        Color lightBlue= new Color(56,134,228,255);
        this.getContentPane().setBackground(lightBlue);
        this.getContentPane().setVisible(true);
        setVisible(true);
        timer = new Timer(3000,new RUN());
        timer.start();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    void check()
    {
        if(jid.getText().equals(s.getAns()))
        {
            score.add();//加分
            NScore.setText("Score:"+score.getScore());
            s.clear();
            s.row(score.getX());
            Jlb_ID.setText(s.getAns());
            jid.setVisible(false);
            Jlb_ID.setVisible(true);
            Jbtn_YES.setVisible(false);
            timer.start();
        }
        else
        {
            setVisible(false);
            result2 res=new result2(score,s.getAns(),jid.getText());
        }
    }
    class keymove extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            switch(e.getKeyCode())
            {
                case KeyEvent.VK_ENTER:check();break;
                case KeyEvent.VK_ESCAPE:System.exit(0);break;
                default:break;
            }
        }
    }
    private class ButtonHandler implements ActionListener 
    {
        public void actionPerformed(ActionEvent evtE) 
        {
            if(evtE.getSource() == Jbtn_YES)
                check();
        }
    }
}