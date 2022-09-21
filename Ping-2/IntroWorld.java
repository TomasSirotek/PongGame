import greenfoot.*;

/**
 * Write a description of class IntroWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroWorld extends Resolution
{
    // private static GameState gameState;
    
    private String text;
    /**
     * Constructor for objects of class IntroWorld.
     */
    public IntroWorld()
    {
        addObject( new Screen("startHalloween.jpg",0), (int)(getWidth() * 0.5), (int)(getHeight() * 0.5));
        // gameState = GameState.NOT_PLAYING;
    }
    
    public void act()
    {
        String key = Greenfoot.getKey();
        
            if (key != null && key.equals("enter"))
            {
                Greenfoot.setWorld(new PingWorld(true));
            }
}
    

    
}
