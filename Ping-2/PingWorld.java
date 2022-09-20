import greenfoot.*;


/**
 * The Ping World is where Balls and Paddles meet to play pong.
 * 
 * @author The teachers 
 * @version 1
 */
public class PingWorld extends World
{
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;
    private static GameState gameState;

    HealthBar hb;
  
    /**
     * Constructor for objects of class PingWorld.
     */
    public PingWorld(boolean gameStarted)
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        
         
        if(gameStarted){
            init();
        }
    }
    
    public void act(){
         if(hb.getHealth() == 0){
                Greenfoot.setWorld(new IntroWorld());
        }
    }
    
    private void init(){

            GreenfootImage background = getBackground();
            background.setColor(Color.BLACK);
            // Create a new world with WORLD_WIDTHxWORLD_HEIGHT cells with a cell size of 1x1 pixels.
            addObject(new Ball(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
            addObject(new Paddle(100,20), 60, WORLD_HEIGHT - 50);
            addObject(new CPUPaddle(100,20),60, Greenfoot.getRandomNumber(400));
            addObject(new LevelBoard("LEVEL"),450, WORLD_HEIGHT - 680);
            hb = new HealthBar(3);
            addObject(hb,60, WORLD_HEIGHT - 680);
             
    }
    


}
