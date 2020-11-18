public class Score2
{
    private int x;
    public Score2()
    {
        x = 0;
    }
    void add()
    {
        x++;
    }
    int getX()
    {
        return x;
    }
    int getScore()
    {
        return (5*x*x+16*x+11)/2;
    }
}
