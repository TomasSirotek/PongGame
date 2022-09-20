import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelBoard extends Actor
{
    private final String SCORE_NAME;
    private int score;
    
    public LevelBoard(String scoreName){
        SCORE_NAME = scoreName;
        score = 0;
        updateImage();
    }
    
    private void updateImage(){
        int fontSize = 20;
        Color textColor = Color.BLACK;
        GreenfootImage img = new GreenfootImage(SCORE_NAME + ":" + score, 24, Color.PINK, Color.CYAN);
        setImage(img);
    }
    
    public void act(){
        score = LevelBoardManager.getScore();
        updateImage();
    }
}