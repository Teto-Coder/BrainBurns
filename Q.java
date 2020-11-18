public class Q
{
    // instance variables - replace the example below with your own
    private String s1,s2;
    private int ans;
    public Q()
    {
        s1="";
        s2="";
        ans=0;
    }
    public String get(){return s1+" □ "+s2;}
    public int getAns(){return ans;}
    public void row()
    {
        s1="";
        s2="";
        ans=(int)(Math.random()*4);
        int b=(int)(Math.random()*20)+1;
        int a;
        if(ans==3)
            a=b*((int)(Math.random()*5)+1);
        else
            a=(int)(Math.random()*20)+1;
        s1+=a;
        s2+=b+" = ";
        switch(ans)
        {
            case 0:s2+=(a+b);break;
            case 1:s2+=(a-b);break;
            case 2:s2+=(a*b);break;
            case 3:s2+=(a/b);break;
            default:break;
        }
    }
    public String getS1(){return s1;}
    public String getS2(){return s2;}
}
