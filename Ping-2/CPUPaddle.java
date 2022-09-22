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
    private GreenfootImage image;
    PingWorld p;
    
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
        p = (PingWorld)getWorld();
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
    if(getX() + width/2 >= getWorld().getWidth() || getX() - width/2 <= 0)
        {
            setLocation(60, Greenfoot.getRandomNumber(300));
        }
    }
    
    private void setImageDamage(){
         if (damageLevel >= 3) {
                setImage("bone.png");
                getImage().scale(80,50);
}         if (damageLevel <= 2) {
                setImage("bone_stage_1.png");
                getImage().scale(80,50);
            }
         if (damageLevel <= 1) {
                setImage("bone_stage_2.png");
                getImage().scale(80,50);
        }
        if (damageLevel == 0) {
               this.setLocation(60, Greenfoot.getRandomNumber(400));
               damageLevel = 3;
               setImage("bone.png");
               p.getHealthBar().healthUp(1); 
        }
    }
    
    public void dealDamage(int damage){
        damageLevel -= damage;
    }
}
