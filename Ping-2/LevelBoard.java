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
    public int score;
    private String prefix;
    private GreenfootImage background;
    
     public LevelBoard()
    {
        this(new String());
    }
    
    public LevelBoard(String prefix){
        background = getImage();  // get image from class
         this.prefix = prefix;
        score = 0;
        updateImage();
    }
    
   //  private void updateImage(){
       // GreenfootImage img = new GreenfootImage(score + "",30,Color.WHITE,null);
       // setImage(img);
    // }
    
    public void act(){
        score = LevelBoardManager.getScore();
         updateImage();
    }
    
     /**
     * Sets a text prefix that should be displayed before
     * the counter value (e.g. "Score: ").
     */
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