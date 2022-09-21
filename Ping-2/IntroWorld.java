import greenfoot.*;

/**
 * Write a description of class IntroWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroWorld extends Resolution
{
    private static GameState gameState;
    
    private String text;
    HealthBar hb;
    /**
     * Constructor for objects of class IntroWorld.
     */
    public IntroWorld()
    {
        setBackground(); // needs to add screen
        gameState = GameState.NOT_PLAYING;
    }
    
    public void act()
    {
        String key = Greenfoot.getKey();
        
            if (key != null && key.equals("enter"))
            {
                Greenfoot.setWorld(new PingWorld(true));
            }
}
    
    private void setBackground(){
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.drawString("Welcom to the game Press ENTER to start", WORLD_WIDTH / 2 - 100, WORLD_HEIGHT / 2);
    }
    
}
