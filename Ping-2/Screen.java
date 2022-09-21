import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Screen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Screen extends Actor
{
    public Screen(String pictureURL)
    {
        this.setImage(pictureURL);
    }

    /**
     * 
     */
    public void act()
    {
        getImage().scale((int)(getWorld().getWidth()), (int)(getWorld().getHeight()));
    }
}
