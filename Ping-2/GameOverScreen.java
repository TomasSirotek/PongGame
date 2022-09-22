import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game over screen that loads player when 0 of lifes is achieved
 */
public class GameOverScreen extends Resolution
{
    
    public GameOverScreen()
    {
        addObject( new Screen("startHalloween.jpg"), (int)(getWidth() * 0.5), (int)(getHeight() * 0.5));
        SoundManager.playGameOverSound();
        setInfoText();
        setPaintOrder(Instructions.class,Screen.class);
    }
    public void act(){
       
          String key = Greenfoot.getKey();
          if (key != null && key.equals("enter"))
            {
                Greenfoot.setWorld(new PingWorld(true));
            }
    }
    
     private void setInfoText(){
        Instructions i = new Instructions("You LOST :( \n Highest achieved score : " + LevelBoard.getScore() + 
        "\n Press <Enter> to Restart !",22, Color.ORANGE, Color.BLACK);
        addObject(i,100,100);
        i.setLocation(getWidth()/2,getHeight()/3);
    }
}
