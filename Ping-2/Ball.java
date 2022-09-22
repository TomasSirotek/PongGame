import greenfoot.*;
import java.util.List;


/**
 * A Ball is a thing that bounces of walls and paddles (or at least i should).
 * 
 * @author The teachers 
 * @version 1
 */
public class Ball extends Actor
{
    private static final int BALL_SIZE = 25;
    private static final int BOUNCE_DEVIANCE_MAX = 5;
    private static final int STARTING_ANGLE_WIDTH = 45;
    private static final int DELAY_TIME = 100;

    private boolean hasBouncedHorizontally,
                    hasBouncedVertically,
                    isReverted,
                    hasTouchedPaddle,
                    canSeePaddle,
                    collision;
    private double hitLocation;
    private int speed,
                delay,
                hit;
    public Paddle lastPaddleTouched;
    PingWorld w;
    GifImage myGif = new GifImage("pumpkin.gif");

    /**
     * Contructs the ball and sets it in motion!
     */
    public Ball()
    {
        hit = 0;
        animationOfGif();
        speed = 2;
        init(speed);
    }

    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        w = (PingWorld)getWorld();
        if (delay > 0)
        {
             delay--;
        }
        if(w.getGameStatus() == GameState.NOT_PLAYING){
        }
    
        else if(w.getGameStatus() == GameState.PLAYING || w.getGameStatus() != GameState.LOST  )
        {
            move(speed);
            setImage(myGif.getCurrentImage());
            checkBounceOffWalls();
            checkBounceOffCeiling();
            checkPaddleCollision();
            resetCollision();
            checkRestart();
        }
    }
    
    
    private void animationOfGif(){
    {
       int scalePercent = 20;
       for (GreenfootImage image : myGif.getImages())
        {
        int wide = image.getWidth()*scalePercent/100;
        int high = image.getHeight()*scalePercent/100;
        image.scale(wide, high);
        setRotation(5);
        }
    }
    }

    private void checkHits(){
       CPUPaddle cp = checkCPUPaddleCollision();
        if(cp != null && w != null){
           hit++;
           cp.dealDamage(1);
      }
      if(hit%10 == 0){
           speed++;
           w.getLevelBoard().incrementScore(1);            
          
        }
    }
    /**
     * Returns true if the ball is touching one of the side walls.
     */
    private boolean isTouchingSides()
    {
        return (getX() <= BALL_SIZE/2 || getX() >= getWorld().getWidth() - BALL_SIZE/2);
    }

    /**
     * Returns true if the ball is touching the ceiling.
     */
    private boolean isTouchingCeiling()
    {
        return (getY() <= BALL_SIZE/2);
    }

    /**
     * Returns true if the ball is touching the floor.
     */
    private boolean isTouchingFloor()
    { 
        return (getY() >= getWorld().getHeight() - BALL_SIZE/2);
    }

    /**
     * Check to see if the ball should bounce off one of the walls.
     * If touching one of the walls, the ball is bouncing off.
     */
    private void checkBounceOffWalls()
    {
        if (isTouchingSides())
        {
            if (! hasBouncedHorizontally)
            {
                SoundManager.playHitWalls();
                revertHorizontally();
            }
        }
        else
        {
            hasBouncedHorizontally = false;
        }
    }

    /**
     * Check to see if the ball should bounce off the ceiling.
     * If touching the ceiling the ball is bouncing off.
     */
    private void checkBounceOffCeiling()
    {
        if (isTouchingCeiling())
        {
            if (!hasBouncedVertically)
            {
                SoundManager.playHitWalls();
                revertVertically();
                canSeePaddle = false;
            }
        }
        else
        {
            hasBouncedVertically = false;
        }
    }
    

    private void checkPaddleCollision(){
        Paddle p = checkPlayerPaddleCollision();
        CPUPaddle cp = checkCPUPaddleCollision();
        
        if(p != null || cp != null){
              if(!isReverted && canSeePaddle){
                  if(w.collisionTime + 50 < w.time){
                      collision = false;
                  }
                     Paddle collidedPaddle = p;
                     lastPaddleTouched = collidedPaddle;
                     SoundManager.playHitPaddle();
                     collision = true;
                     revertVertically();
                     w.collisionTime = w.time;
                    if(cp != null){
                        checkHits();
                        SoundManager.playBoneCrack();
                    }       
            }
            } else {
                isReverted = false;
            } 
        }
     
    private Paddle checkPlayerPaddleCollision(){
        Paddle p = (Paddle)getOneObjectAtOffset(-20, 0, Paddle.class);
        if(p == null){
            return null;
        } else {
            return p;
        }
    }
    
     private CPUPaddle checkCPUPaddleCollision(){
        CPUPaddle cp = (CPUPaddle)getOneObjectAtOffset(0, 0, CPUPaddle.class);
        if(cp == null){
            return null;
        } else {
            return cp;
        }
    }
        
    private void resetCollision(){
        if(getY() >= getWorld().getHeight() - 100){
            canSeePaddle = true;
        }
    }
    

    /**
     * Check to see if the ball should be restarted.
     * If touching the floor the ball is restarted in initial position and speed.
     */
    private void checkRestart()
    {
        if (isTouchingFloor())
        {
             w.collisionTime = w.time;
             SoundManager.playHitFloor();
             w.getHealthBar().dealDamage(1);
             init(speed);
             setLocation(getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        }
    }

    /**
     * Bounces the ball back from a vertical surface.
     */
    private void revertHorizontally()
    {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX)- BOUNCE_DEVIANCE_MAX / 2;
        setRotation((180 - getRotation()+ randomness + 360) % 360);
        hasBouncedHorizontally = true;
    }

    /**
     * Bounces the bal back from a horizontal surface.
     */
    private void revertVertically()
    {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX)- BOUNCE_DEVIANCE_MAX / 2;
        setRotation((360 - getRotation()+ randomness + 360) % 360);
        hasBouncedVertically = true;
    }

    /**
     * Initialize the ball settings.
     */
    private void init(double speed)
    {
        speed = speed;
        delay = DELAY_TIME;
        canSeePaddle = true;
        hasBouncedHorizontally = false;
        hasBouncedVertically = false;
        setRotation(Greenfoot.getRandomNumber(STARTING_ANGLE_WIDTH) + STARTING_ANGLE_WIDTH/2);

    }

}
