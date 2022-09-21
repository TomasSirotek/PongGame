import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelBoard extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    public  int score;
    private String prefix;
    private GreenfootImage background;
    LevelBoardManager lbm;
    PingWorld p;

    public LevelBoard()
    {
        this(new String());
        score = 0;
    }

    public LevelBoard(String prefix){
        background = getImage();  
        this.prefix = prefix;
        score = 0;
        updateImage();
    }

    public void act(){
        score = lbm.getScore();
        updateImage();
    }
    
    public void resetScore(){
        score = 0;
    }

    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
        updateImage();
    }

    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage(prefix + score, 28, Color.WHITE, transparent);

        image.scale(120,105);

        image.drawImage(text, (image.getWidth()-text.getWidth() + 30 )/2, 
            (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }

}