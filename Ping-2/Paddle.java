import greenfoot.*;


/**
 * A paddle is an object that goes back and forth. Though it would be nice if balls would bounce of it.
 * 
 * @author The teachers 
 * @version 1
 */
public class Paddle extends Actor
{
    private int width;
    private int height;
    private int dx;
    private GreenfootImage image;
    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Paddle(int width, int height)
    {
        this.width = width;
        this.height = height;
        image = getImage();  
        dx = 2;
        createImage();
    }

    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        keyInput();
        checkForWorldEdges();
    }    

    private void keyInput(){
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX() + dx, getY());
        }
         if(Greenfoot.isKeyDown("left")){
            setLocation(getX() - dx, getY());
        }
    }
    
    private void checkForWorldEdges(){
        int worldWidth = getWorld().getWidth();
        int spriteWidth = getImage().getWidth()/2;

        if( getX() > worldWidth - spriteWidth)
        setLocation(worldWidth - spriteWidth, getY());

        if(getX() < spriteWidth)
        setLocation(spriteWidth, getY());
        
    }

    /**
     * Creates and sets an image for the paddle, the image will have the same dimensions as the paddles width and height.
     */
    private void createImage()
    {
      setImage(image);  
      image.scale(140,60);
    }

}
