import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game over screen that loads player when 0 of lifes is achieved
 */
public class GameOverScreen extends Resolution
{
    
    public GameOverScreen()
    {
        addObject( new Screen("startHalloween.jpg","You LOST :( " + 
        "\n Highest achieved score : "+
        LevelBoard.getScore() + 
        "\n Press <Enter> to Restart !",0
        ), (int)(getWidth() * 0.5), (int)(getHeight() * 0.5));
    }
    public void act(){
          String key = Greenfoot.getKey();
          if (key != null && key.equals("enter"))
            {
                Greenfoot.setWorld(new PingWorld(true));
            }
    }
}
