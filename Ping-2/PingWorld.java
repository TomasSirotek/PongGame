import greenfoot.*;

/**
 * The Ping World is where Balls and Paddles meet to play pong.
 * 
 * @author The teachers 
 * @version 1
 */
public class PingWorld extends Resolution
{
    private static GameState state;
    public int collisionTime,time;
    HealthBar hb;
    LevelBoard lb;
    Counter c;
    SoundManager sm;
    Paddle p;

    
    /**
     * Constructor for objects of class PingWorld.
     */
    public PingWorld(boolean setGame)
    {
        addObject( new Screen("startHalloween.jpg"), (int)(getWidth() * 0.5), (int)(getHeight() * 0.5));
        state = GameState.NOT_PLAYING;
        if(setGame){
            init();
        }     
    }

    public void act(){
        time += 1;
        if (state == GameState.NOT_PLAYING) 
        {
            if (c.getValue() == 0 )
            {
                removeObject(c);
                state = GameState.PLAYING;
                SoundManager.playThemeMusic();
            } 
        }
        else if ( state == GameState.PLAYING )
        {
            if (hb.getHealth() == 0)
            {
                SoundManager.stopThemeMusic();
                state = GameState.LOST;
            } 
        }
        else if ( state == GameState.LOST )
        {
            Greenfoot.setWorld(new GameOverScreen());   
        }

    }
    private void init(){
        lb = new LevelBoard();
        c = new Counter();
        hb = new HealthBar(3);
        p = new Paddle(140,60);
        addObject(new Ball(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
        addObject(new CPUPaddle(100,20),60, Greenfoot.getRandomNumber(320));
        addObject(p, 60, WORLD_HEIGHT - 20);
        addObject(lb,470, WORLD_HEIGHT - 680);
        addObject(c,WORLD_WIDTH/2, WORLD_HEIGHT/2 - 300);
        addObject(hb,60, WORLD_HEIGHT - 680);
        
        setPaintOrder(Ball.class,Paddle.class,Counter.class,CPUPaddle.class,HealthBar.class,LevelBoard.class,Screen.class);
        
       
    }

    public GameState getGameStatus()
    {
        return state;
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
    public Paddle getPaddle(){
        return p;
    }


}
