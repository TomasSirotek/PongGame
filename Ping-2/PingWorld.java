import greenfoot.*;


/**
 * The Ping World is where Balls and Paddles meet to play pong.
 * 
 * @author The teachers 
 * @version 1
 */
public class PingWorld extends Resolution
{
   //  private static GameState gameState;
    HealthBar hb;
    LevelBoard lb;
    
    GameState state;
    Counter c;
    /**
     * Constructor for objects of class PingWorld.
     */
    public PingWorld(boolean setGame)
    {
        
        addObject( new Screen("startHalloween.jpg","",0), (int)(getWidth() * 0.5), (int)(getHeight() * 0.5));
        state = GameState.NOT_PLAYING;
    if(setGame){
        init();
    }     
    }
    
    public void act(){

        String key = Greenfoot.getKey();
        
        int test = c.getValue(); 
           
        if (state == GameState.NOT_PLAYING) 
        {
            if (c.getValue() == 0 )
            {
                removeObject(c);
                state = GameState.PLAYING;
            } 
        }
        else if ( state == GameState.PLAYING )
        {
            if (hb.getHealth() == 0)
            {
                state = GameState.LOST;
            } 
        }
        else if ( state == GameState.LOST )
        {
           Greenfoot.setWorld(new GameOverScreen());   
             
        }
       
         
    }
    
    private void init(){
         c = new Counter();
            addObject(c,WORLD_WIDTH/2, WORLD_HEIGHT/2 - 300);

            GreenfootImage background = getBackground();
            background.setColor(Color.BLACK);
            // Create a new world with WORLD_WIDTHxWORLD_HEIGHT cells with a cell size of 1x1 pixels.
            addObject(new Ball(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
            addObject(new Paddle(100,20), 60, WORLD_HEIGHT - 50);
            addObject(new CPUPaddle(100,20),60, Greenfoot.getRandomNumber(400));
            
            LevelBoard lb = new LevelBoard();
            addObject(lb,470, WORLD_HEIGHT - 680);
            
            hb = new HealthBar(3);
            addObject(hb,60, WORLD_HEIGHT - 680);
            
            // addObject(new Level(),450, WORLD_HEIGHT - 680);
            
           
             
    }
    
     public GameState getGameStatus()
    {
        return state;
        
    } 
    


}
