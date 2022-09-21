import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Screen class that sets up new screen with generic resolution
 * Take pictureURL and 0 - to display instruction and 1 - not to display them
 */
public class Screen extends Actor
{
    private int switchStage;
    private String instructions;
    
    public Screen(String pictureURL,String instructions,int switchStage)
    {
        this.setImage(pictureURL);
        this.instructions = instructions;
        this.switchStage = switchStage;
    }
    public void act()
    {
        hasInstructions(switchStage);
    }

    private void hasInstructions(int switchStage){
        switch(switchStage){
            case 0:
                setBg();     
            case 1:
                break;
        }
        
    }
    
    private void setBg(){
        getImage().scale((int)(getWorld().getWidth()),(int)(getWorld().getHeight()));
        Instructions i = new Instructions(instructions,25, Color.ORANGE, Color.BLACK);
        getWorld().addObject(i,500,170);
        i.setLocation(getWorld().getWidth()/2,getWorld().getHeight()/4);
    }
}
