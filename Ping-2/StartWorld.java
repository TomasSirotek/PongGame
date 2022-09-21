import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartWorld extends Resolution
{

    /**
     * Constructor for objects of class StartWorld.
     * 
     */
    public StartWorld()
    {
         addObject( new Screen("startHalloween.jpg"), (int)(getWidth() * 0.5), (int)(getHeight() * 0.5)); 
    }
}
