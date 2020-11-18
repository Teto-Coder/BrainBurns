import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.*;
public class color extends JFrame{
    JLabel Times,p1c,p2c;
    JLabel[] W=new JLabel[4],U=new JLabel[4];
    int TT=30;
    Timer timer;
    int Rand[]={-1,-1};
    String S[]={"紅","黃","藍","綠","白","黑","紫"};
    Color C[]={Color.RED,Color.YELLOW,Color.BLUE,Color.GREEN,Color.WHITE,Color.BLACK,new Color(138,43,226)};
    score P1,P2;
    public void setVis(boolean b){setVisible(b);}
    void next(int who){
        JLabel[] X;
        if(who==0){
            X=W;
        }
        else{
            X=U;
        }
        Random rand=new Random();
        Rand[who]=rand.nextInt(4);
        for(int i=0;i<4;i++){
            int k;
            if(i==Rand[who]){
                int kk;
                do{
                    k=rand.nextInt(7);
                    kk=rand.nextInt(7);
                }while(k==kk);
                X[i].setText(S[kk]);
                X[i].setBackground(C[k]);
            }
            else{
                k=rand.nextInt(7);
                X[i].setText(S[k]);
                X[i].setBackground(C[k]);
            }
            if(k==1 || k==4){
                X[i].setForeground(Color.BLACK);
            }
            else X[i].setForeground(Color.WHITE);
        }
    }
    color(score p1,score p2){
        P1=p1;
        P2=p2;
        Times=new JLabel("times:30s");
        Times.setFont(new java.awt.Font("dialog",0,24));
        Times.setBounds(320,43,135,39);
        add(Times);
        p1c=new JLabel("0");
        p1c.setFont(new java.awt.Font("dialog",0,24));
        p1c.setBounds(163,198,51,39);
        add(p1c);
        p2c=new JLabel("0");
        p2c.setFont(new java.awt.Font("dialog",0,24));
        p2c.setBounds(547,198,51,39);
        add(p2c);
        int WB[][]={{139,60},{245,166},{139,272},{33,166}},UB[][]={{523,60},{629,166},{523,272},{417,166}};
        for(int i=0;i<4;i++){
            W[i]=new JLabel("-1",JLabel.CENTER);
            W[i].setOpaque(true);
            W[i].setBounds(WB[i][0],WB[i][1],100,100);
            W[i].setFont(new java.awt.Font("dialog",1,48));
            W[i].setForeground(Color.WHITE);
            add(W[i]);
            U[i]=new JLabel("-1",JLabel.CENTER);
            U[i].setOpaque(true);
            U[i].setBounds(UB[i][0],UB[i][1],100,100);
            U[i].setFont(new java.awt.Font("dialog",1,48));
            U[i].setForeground(Color.WHITE);
            add(U[i]);
        }
        next(0);
        next(1);
        TimerD timed=new TimerD();
        timer=new Timer(1000,timed);
        addKeyListener(new keymove());
        setTitle("顏色陷阱");
        setLayout(null);
        setBounds(100,100,778,458);
        setVisible(true);
        timer.start();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    class TimerD extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
            TT--;
            Times.setText("times:"+TT+"s");
            if(TT==0){
                timer.stop();
                setVis(false);
                result res=new result(P1,P2);
            }
        }
    }
   
    class Wvisible extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
           time1.stop();
           for(int i=0;i<4;i++)W[i].setVisible(true); 
        }
    }
    class Uvisible extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
           time2.stop();
           for(int i=0;i<4;i++)U[i].setVisible(true); 
        }
    }
    Wvisible Wv=new Wvisible();
    Uvisible Uv=new Uvisible();
    Timer time1=new Timer(50,Wv),time2=new Timer(50,Uv);
    class keymove extends KeyAdapter{
        Play correct=new Play("crrect.mp3"),wrong=new Play("wrong.mp3");
        public void keyPressed(KeyEvent e){
            int RedDir=-1,BlueDir=-1;
            int flag=1;
            switch(e.getKeyCode()){
                case KeyEvent.VK_UP:BlueDir=0;break;
                case KeyEvent.VK_DOWN:BlueDir=2;break;
                case KeyEvent.VK_LEFT:BlueDir=3;break;
                case KeyEvent.VK_RIGHT:BlueDir=1;break;
                case KeyEvent.VK_W:RedDir=0;break;
                case KeyEvent.VK_S:RedDir=2;break;
                case KeyEvent.VK_A:RedDir=3;break;
                case KeyEvent.VK_D:RedDir=1;break;
                default:flag=0;
            }
            if(flag==1){
                if(RedDir==Rand[0]){
                    correct.p();
                    P1.AddDirCorrect();
                    next(0);
                    
                }
                else if(RedDir!=-1){
                    W[RedDir].setVisible(false);
                    wrong.p();
                    P1.AddDirWrong();
                    time1.start();
                    //Red.setVisible(true);
                }
                if(BlueDir==Rand[1]){
                    correct.p();
                    P2.AddDirCorrect();
                    next(1);
                    //BlueNext();
                    
                }
                else if(BlueDir!=-1){
                    //Blue.setVisible(false);
                    U[BlueDir].setVisible(false);
                    wrong.p();
                    P2.AddDirWrong();
                    time2.start();
                    //Blue.setVisible(true);
                    
                }
                p1c.setText(String.valueOf(P1.cnt));
                p2c.setText(String.valueOf(P2.cnt));
            }
            
        }
    }
}