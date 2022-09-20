/**
 * Write a description of class ScoreBoardManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelBoardManager  
{
    private static int MAX_SCORE;

    /**
     * Constructor for objects of class ScoreBoardManager
     */
    public LevelBoardManager()
    {
    }
    
    public static void incrementScore(int howMuch){
        MAX_SCORE += howMuch;
    }
    
    public static int getScore(){
        return MAX_SCORE;
    }
}
