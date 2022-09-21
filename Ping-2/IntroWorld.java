import greenfoot.*;

/**
 * Write a description of class IntroWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroWorld extends Resolution
{
    private String text;
    GameState state;
    HealthBar hb;
    /**
     * Constructor for objects of class IntroWorld.
     */
    // "\n \n \n GAME RULES \n => You have 3 lifes \n => Your goal is to bounce the ball of your \n platform without ball touching the floor \n Bone has 3 stages of damage, if you destroy the bone you gain one EXTRA life \n Each 10 time you hit the bone speed of the ball increases ! \n Try to get the highest score possible ! \n Have Fun !! "
    public IntroWorld()
    {
        addObject( new Screen("startHalloween.jpg","Press <Enter> to start" ,0), (int)(getWidth() * 0.5), (int)(getHeight() * 0.5));
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
