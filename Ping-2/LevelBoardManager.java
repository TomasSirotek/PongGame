/**
 * Write a description of class ScoreBoardManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelBoardManager  
{
    public static int score;
    
    /**
     * Constructor for objects of class ScoreBoardManager
     */
    public LevelBoardManager()
    {
        score = 0;
    }
    
    public void incrementScore(int howMuch){
        score += howMuch;
    }
    
    public static int getScore(){
        return score;
    }
}
