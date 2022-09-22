import greenfoot.*;

public class IntroWorld extends Resolution
{
    private String text;
    GameState state;
    HealthBar hb;
    /**
     * Constructor for objects of class IntroWorld.
     */
    public IntroWorld()
    {
        addObject(new Screen("run_screen.jpg"), (int)(getWidth() * 0.5), (int)(getHeight() * 0.5));
        setInfoText();
        setPaintOrder(Instructions.class,Screen.class);
    }
    
    public void act()
    {
        SoundManager.playStartMusic();
        String key = Greenfoot.getKey();
       
             if (key != null && key.equals("enter"))
             {
                SoundManager.stopStartMusic();
                Greenfoot.setWorld(new PingWorld(true));
             }
}    
    private void setInfoText(){
        Instructions i = new Instructions("How to play\n 1.Use arrow keys to move the bat\n 2.Try to break the bone with the pumpkin\n 3.You have 3 lifes\n 4.When the bone breaks\n you gain extra life\n Every 10 hit to the bone\n level and speed increases \n5.Try to get the highest\n score\n Have fun! \n\nPress <Enter> to start",22, Color.ORANGE, Color.BLACK);
        addObject(i,100,100);
        i.setLocation(getWidth()/2,getHeight()/2 + 100);
    }
}
