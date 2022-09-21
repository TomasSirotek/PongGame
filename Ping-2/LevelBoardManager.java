/**
 * Write a description of class ScoreBoardManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelBoardManager  
{
    private static int score;

    /**
     * Constructor for objects of class ScoreBoardManager
     */
    public LevelBoardManager()
    {
    }
    
    public static void incrementScore(int howMuch){
        score += howMuch;
    }
    
    public static int getScore(){
        return score;
    }
}
