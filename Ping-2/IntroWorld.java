import greenfoot.*;

/**
 * Write a description of class IntroWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroWorld extends World
{
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;
    private static GameState gameState;
    
    private String text;
    HealthBar hb;
    /**
     * Constructor for objects of class IntroWorld.
     */
    public IntroWorld()
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1); 

        setBackground();
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
        background.drawString("Press ENTER to start", WORLD_WIDTH / 2 - 100, WORLD_HEIGHT / 2);
    }
    
}
