public class score{
    int DirCorrect,DirWrong,rate,cnt;
    void AddDirCorrect(){
        DirCorrect++;
        cnt+=5;
        if(DirCorrect+DirWrong!=0)rate=100*DirCorrect/(DirCorrect+DirWrong);
    }
    void AddDirWrong(){
        DirWrong++;
        //if(cnt>=5)
        cnt-=5;
        if(DirCorrect+DirWrong!=0)rate=100*DirCorrect/(DirCorrect+DirWrong);
    }
    score(){
        DirCorrect=0;
        DirWrong=0;
        rate=0;
        cnt=0;
    }
}