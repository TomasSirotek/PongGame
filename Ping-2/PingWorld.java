import greenfoot.*;

/**
 * The Ping World is where Balls and Paddles meet to play pong.
 * 
 * @author The teachers 
 * @version 1
 */
public class PingWorld extends Resolution
{
    HealthBar hb;
    LevelBoardManager lbm;
    LevelBoard lb;
    GameState state;
    Counter c;
    SoundManager sm;
    
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
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        addObject(new Ball(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
        addObject(new Paddle(100,20), 60, WORLD_HEIGHT - 50);
        addObject(new CPUPaddle(100,20),60, Greenfoot.getRandomNumber(400));
        lbm = new LevelBoardManager();
        LevelBoard lb = new LevelBoard();
        addObject(lb,470, WORLD_HEIGHT - 680);
        c = new Counter();
        addObject(c,WORLD_WIDTH/2, WORLD_HEIGHT/2 - 300);
        hb = new HealthBar(3);
        addObject(hb,60, WORLD_HEIGHT - 680);

    }

    public GameState getGameStatus()
    {
        return state;
    } 
    
    public LevelBoardManager getLevelBoardManager(){
        return lbm;
    }
    
    public LevelBoard getLevelBoard(){
        return lb;
    }
    public HealthBar getHealthBar(){
        return hb;
    }
    
    public SoundManager getSoundManager(){
        return sm;
    }


}
