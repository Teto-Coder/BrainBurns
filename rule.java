import javax.swing.*;
import java.awt.event.*;
public class rule extends JFrame{
    ImageIcon rulepic=new ImageIcon();
    score P1,P2;
    int g;
    rule(String path,int g){
       this.g=g;
       P1=new score();
       P2=new score();
       rulepic=new ImageIcon(path);
       JLabel rulelab=new JLabel(rulepic);
       rulelab.setBounds(0,0,576,859);
       add(rulelab);
       rulelab.addMouseListener(new MouseClick());
       setTitle("規則介紹"); 
       setLayout(null);
       setBounds(100,100,600,900);
       setVisible(true);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
    }
    class MouseClick extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            
        }
        public void mouseClicked(MouseEvent e){
            setVisible(false);
            switch(g){
                case 0:Dir login=new Dir(P1,P2);break;
                case 1:color c=new color(P1,P2);break;
                case 2:Panel1 pw = new Panel1();break;
                case 3:Panel pw1 = new Panel();break;
            }
        }
    }
}