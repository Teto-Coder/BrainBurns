import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class guide extends JFrame{
    JLabel[] l=new JLabel[4];
    ImageIcon[] icon=new ImageIcon[4];
    //String S[]={"方向達人","顏色陷阱","",""};
    int lb[][]={{33,38},{185,38},{33,205},{185,205}};
    
    guide(){
       for(int i=0;i<4;i++){
           icon[i]=new ImageIcon("guide"+(i+1)+".png");
           l[i]=new JLabel(icon[i]);
           l[i].setBounds(lb[i][0],lb[i][1],120,136);
           //l[i].setFont(new java.awt.Font("dialog",1,24));
           add(l[i]);
       }
       score p1=new score(),p2=new score();
       for(int i=0;i<4;i++)l[i].addMouseListener(new MouseClick(i));
       setTitle("BrainBurns"); 
       setLayout(null);
       setBounds(100,100,351,419);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    class MouseClick extends MouseAdapter{
        //score P1=new score(),P2=new score();
        String SS[]={"dirrule.jpg","colorrule.jpg","operrule.png","numrule.jpg"};
        int K;
        MouseClick(int k){
            K=k;
        }
        public void mouseClicked(MouseEvent e){
                rule r=new rule(SS[K],K);
        }
    }
}