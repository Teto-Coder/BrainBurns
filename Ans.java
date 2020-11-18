public class Ans
{
    // instance variables - replace the example below with your own
    private String s;
    public Ans()
    {
        s="";
        s+=(int)(Math.random()*10);
    }
    public String getAns()
    {
        return s;
    }
    public String row(int score)
    {
        for(int i=0;i<=score;i++)
            s+=(int)(Math.random()*10);
        return s;
    }
    public void clear()
    {
        s="";
    }
}
