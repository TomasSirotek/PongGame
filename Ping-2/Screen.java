import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Screen class that sets up new screen with generic resolution
 * Take pictureURL and 0 - to display instruction and 1 - not to display them
 */
public class Screen extends Actor
{
  
    public Screen(String pictureURL)
    {
        this.setImage(pictureURL);  
    }
}
