import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
//import java.awt.Image.*;
class Dir extends JFrame{
    Play correct=new Play("crrect.mp3"),wrong=new Play("wrong.mp3");
    private JLabel Red,Blue,Play1,Play2,Times;
    public int BlueRandDir=-1,RedRandDir=-1,RedColor=-1,BlueColor=-1;//0 means Red,1 means Blue
    ImageIcon[] icoRed=new ImageIcon[4],icoBlue=new ImageIcon[4],icoRedd=new ImageIcon[4],icoBluee=new ImageIcon[4];
    score P1,P2;
    int TT=30;
    TimerD timed=new TimerD();
    Timer timer =new Timer(1000,timed);
    public void setVis(boolean b){setVisible(b);}
    class TimerD extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
            TT--;
            Times.setText(TT+"s");
            if(TT==0){
                timer.stop();
                setVis(false);
                result res=new result(P1,P2);
            }
        }
    }
    Dir(score p1,score p2){
        P2=p2;
        P1=p1;     
        for(int i=1;i<=4;i++){
            icoRed[i-1]=new ImageIcon("red"+i+".png");
            icoBlue[i-1]=new ImageIcon("blue"+i+".png");
            icoRedd[i-1]=new ImageIcon("red"+i+i+".png");
            icoBluee[i-1]=new ImageIcon("blue"+i+i+".png");
            //icoRed[i-1]=icoRed[i-1].getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        }
        Play1=new JLabel("PLAY1:0");
        Play1.setFont(new java.awt.Font("dialog",0,36));
        Play1.setBounds(81,40,180,58);
        add(Play1);
        Play2=new JLabel("PLAY2:0");
        Play2.setFont(new java.awt.Font("dialog",0,36));
        Play2.setBounds(473,40,180,58);
        add(Play2);
        Times=new JLabel("30s");
        Times.setFont(new java.awt.Font("dialog",0,36));
        Times.setBounds(323,152,73,58);
        add(Times);
        Red=new JLabel(icoRed[0]);
        Red.setBounds(59,120,200,200);
        add(Red);
        RedNext();
        Blue=new JLabel(icoBlue[0]);
        Blue.setBounds(451,120,200,200);
        add(Blue);
        BlueNext();
        addKeyListener(new keymove());
        setTitle("方向達人");
        setLayout(null);
        setBounds(100,100,734,420);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //CkeyMove keyMove=new Ckeymove();
        
        timer.start();
    }
    
    void RedNext(){
        Random rand=new Random();
        RedRandDir=rand.nextInt(4);
        RedColor=rand.nextInt(2);
        Red.setBounds(49,110,220,220);
        if(RedColor==0){
            Red.setIcon(icoRedd[RedRandDir]); 
        }
        else{
            Red.setIcon(icoBluee[RedRandDir]);
        }
        time11.start();
    }
    void BlueNext(){
        Random rand=new Random();
        BlueRandDir=rand.nextInt(4);
        BlueColor=rand.nextInt(2);
        Blue.setBounds(441,110,220,220);
        if(BlueColor==0){
            Blue.setIcon(icoRedd[BlueRandDir]); 
        }
        else{
            Blue.setIcon(icoBluee[BlueRandDir]);
        }
        time22.start();
    }
    class Redvisible extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
           time1.stop();
           Red.setVisible(true); 
        }
    }
    class Bluevisible extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
            time2.stop();
            Blue.setVisible(true);
        }
    }
    class Redsmall extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
           time11.stop();
           Red.setBounds(59,120,200,200);
           if(RedColor==0){
                Red.setIcon(icoRed[RedRandDir]); 
            }
            else{
                Red.setIcon(icoBlue[RedRandDir]);
            }
        }
    }
    class Bluesmall extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
           time22.stop();
           Blue.setBounds(451,120,200,200);
           if(BlueColor==0){
                Blue.setIcon(icoRed[BlueRandDir]); 
            }
            else{
                Blue.setIcon(icoBlue[BlueRandDir]);
            } 
        }
    }
    Redvisible rv=new Redvisible();
    Bluevisible bv=new Bluevisible();
    Bluesmall bs=new Bluesmall();
    Redsmall rs=new Redsmall();
    Timer time1=new Timer(50,rv),time2=new Timer(50,bv),time11=new Timer(50,rs),time22=new Timer(50,bs);
    class keymove extends KeyAdapter{
        
        public void keyPressed(KeyEvent e){
            int RedDir=-1,BlueDir=-1;
            int flag=1;
            switch(e.getKeyCode()){
                case KeyEvent.VK_UP:BlueDir=1;break;
                case KeyEvent.VK_DOWN:BlueDir=3;break;
                case KeyEvent.VK_LEFT:BlueDir=0;break;
                case KeyEvent.VK_RIGHT:BlueDir=2;break;
                case KeyEvent.VK_W:RedDir=1;break;
                case KeyEvent.VK_S:RedDir=3;break;
                case KeyEvent.VK_A:RedDir=0;break;
                case KeyEvent.VK_D:RedDir=2;break;
                case KeyEvent.VK_ESCAPE:timer.stop();setVis(false);break;
                default:flag=0;
            }
            if(flag==1){
                if(RedColor==0){
                    switch(RedDir){
                        case 0:RedDir=2;break;
                        case 1:RedDir=3;break;
                        case 2:RedDir=0;break;
                        case 3:RedDir=1;break;
                        default:RedDir=-1;
                    }
                }
                if(BlueColor==0){
                    switch(BlueDir){
                        case 0:BlueDir=2;break;
                        case 1:BlueDir=3;break;
                        case 2:BlueDir=0;break;
                        case 3:BlueDir=1;break;
                        default:BlueDir=-1;
                    }
                }
                
                if(RedDir==RedRandDir){
                    correct.p();
                    P1.AddDirCorrect();
                    RedNext();
                    
                }
                else if(RedDir!=-1){
                    Red.setVisible(false);
                    wrong.p();
                    P1.AddDirWrong();
                    time1.start();
                    //Red.setVisible(true);
                }
                if(BlueDir==BlueRandDir){
                    correct.p();
                    P2.AddDirCorrect();
                    BlueNext();
                    
                }
                else if(BlueDir!=-1){
                    Blue.setVisible(false);
                    wrong.p();
                    P2.AddDirWrong();
                    time2.start();
                    //Blue.setVisible(true);
                    
                }
                Play1.setText("PLAY1:"+P1.cnt);
                Play2.setText("PLAY2:"+P2.cnt);
            }
            
        }
    }
}