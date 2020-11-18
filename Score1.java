public class Score1
{
    private int Correct;
    private int Miss;
    public Score1()
    {
        Correct = 0;
        Miss = 0;
    }
    public void add(boolean n)
    {
        if(n)
            Correct++;
        else
            Miss++;
    }
    public int getCorrect(){return Correct;}
    public int getMiss(){return Miss;}
    public int getScore()
    {
        return (Correct-Miss)*20;
    }
}
