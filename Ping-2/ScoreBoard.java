import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor
{
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
        
 private final String SCORE_NAME;
    private int score;
    
    public ScoreBoard(String scoreName){
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
        score = ScoreBoardManager.getScore();
        updateImage();
    }
}