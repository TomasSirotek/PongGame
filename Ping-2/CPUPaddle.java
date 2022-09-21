import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CPUPaddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CPUPaddle extends Actor
{
    private int width;
    private int height;
    private int dx;
    
    private int damageLevel;
    
     public CPUPaddle(int width, int height)
    {
        this.width = width;
        this.height = height;
        damageLevel = 3;
        dx = 1;
        createImage();
    }
    /**
     * Act - do whatever the CPUPaddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImageDamage();
        tryChangeDirection();
        setLocation(getX() + dx, getY());
    }
    
    private void createImage()
    {
        setImage("bone.png");
        GreenfootImage image = getImage();  
        image.scale(80,50); 
        setImage(image);
    }
    
    /**
     * Will rotate the paddle 180 degrees if the paddle is at worlds edge.
     */
    private void tryChangeDirection()
    {
        //Check to see if we are touching the outer boundaries of the world:
        // IF we are touching the right boundary OR we are touching the left boundary:
    if(getX() + width/2 >= getWorld().getWidth() || getX() - width/2 <= 0)
        {
            //Change our 'x' direction to the inverted direction:
            setLocation(60, Greenfoot.getRandomNumber(400));
        }
    }
    
    private void setImageDamage(){
         if (damageLevel >= 3) {
                setImage("bone.png");
                getImage().scale(80,50);
                // play crack sound
            }
         if (damageLevel <= 2) {
                setImage("baby1.png");
                getImage().scale(90,90);
            }
         if (damageLevel <= 1) {
                setImage("heart1.png");
                 getImage().scale(90,90);
            }
    }
    
    public void dealDamage(int damage){
        damageLevel -= damage;
    }
}
