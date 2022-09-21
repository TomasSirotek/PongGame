import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends Resolution
{
    
    /**
     * Constructor for objects of class GameOverScreen.
     * 
     */
    public GameOverScreen()
    {
        addObject( new Screen("startHalloween.jpg",1), (int)(getWidth() * 0.5), (int)(getHeight() * 0.5));
        Instructions i = new Instructions("HightScore: " + LevelBoardManager.getScore());
        addObject(i,500,170);
        i.setLocation(getWidth()/2,getHeight()/4);
      
    }
    public void act(){
          String key = Greenfoot.getKey();
        
            if (key != null && key.equals("enter"))
            {
                Greenfoot.setWorld(new PingWorld(true));
            }
    }
}
